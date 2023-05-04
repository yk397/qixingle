package com.sixandone.qixingle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName yk
 * @Descprition:配置安全认证信息
 * @Autor DELL
 * @Date 2023/5/1 14:33
 **/
@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() //授权http请求
                .mvcMatchers("/userLogin/**")
                .permitAll();
    }

}
