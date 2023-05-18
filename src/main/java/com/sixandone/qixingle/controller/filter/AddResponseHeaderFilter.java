package com.sixandone.qixingle.controller.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName yk
 * @Descprition: 全局增加响应头
 * @Autor DELL
 * @Date 2023/5/18 16:47
 **/
@Component
public class AddResponseHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final Date date = new Date();
        response.addHeader("Server","qixingle");
        response.addHeader("Date",date.toString());
    }
}
