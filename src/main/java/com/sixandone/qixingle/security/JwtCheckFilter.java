package com.sixandone.qixingle.security;

import com.sixandone.qixingle.util.JwtUtils;
import com.sixandone.qixingle.util.json.JsonUtils;
import com.sixandone.qixingle.vo.HttpResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName yk
 * @Descprition: jwt token 校验器
 * @Autor DELL
 * @Date 2023/5/11 17:58
 **/
@Component
public class JwtCheckFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        //如果是登录请求uri，直接放行
        if(requestURI.equals("/wx/user/{appid}/**")){
            doFilter(request,response,filterChain);
            return;
        }
        String auth = request.getHeader("Authorization");
        if (StringUtils.isEmpty(auth)) {
            HttpResult httpResult = HttpResult.builder()
                    .code("0")
                    .msg("jwt 为空")
                    .build();
            printToken(request,response,httpResult);
            return;
        }
        String jwt = auth.replace("bearer","");//把bearer替换成空
        if (StringUtils.containsWhitespace(jwt)) {
            HttpResult httpResult = HttpResult.builder()
                    .code("0")
                    .msg("jwt 为空")
                    .build();
            printToken(request,response,httpResult);
            return;
        }
        //校验jwt
        boolean verifyToken = jwtUtils.verifyToken(jwt);
        if (!verifyToken) {
            HttpResult httpResult = HttpResult.builder()
                    .code("0")
                    .msg("jwt 无效")
                    .build();
            printToken(request,response,httpResult);
            return;
        }

        //获取用户信息和权限信息
        String openid = jwtUtils.getUserOpenId(jwt);
        List<String> authlist = jwtUtils.getUserAuthFromToken(jwt);
        List<SimpleGrantedAuthority> authorityList = authlist.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        //认证token
        MyAuthenticationToken token = new MyAuthenticationToken(authorityList, openid, null);
        //把认证信息放到安全上下文里面，securityContext
        SecurityContextHolder.getContext().setAuthentication(token);
        doFilter(request,response,filterChain);//放行
    }

    private void printToken(HttpServletRequest request, HttpServletResponse response, HttpResult httpResult) throws IOException {
        String strResponse = JsonUtils.toJson(httpResult);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(strResponse);
        writer.flush();
    }
}
