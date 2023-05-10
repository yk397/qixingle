package com.sixandone.qixingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @ClassName yk
 * @Descprition:自定义认证，解析前端数据
 * @Autor DELL
 * @Date 2023/5/4 22:17
 **/
@Component
public class MyUserNamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {




    public MyUserNamePasswordAuthenticationFilter(){
        super(new AntPathRequestMatcher("userLogin/userLogin1","GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
