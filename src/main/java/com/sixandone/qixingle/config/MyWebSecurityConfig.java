package com.sixandone.qixingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName yk
 * @Descprition:接口安全配置
 * @Autor DELL
 * @Date 2023/5/5 14:07
 **/
@Configuration
public class MyWebSecurityConfig {

    /**
     * 配置认证成功处理器
     */
    @Autowired
    private loginSuccessHandler loginSuccessHandler;

    /**
     * 配置接口请求的restTemplate
     * @return
     */
    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .mvcMatchers("/userLogin/**")
                .permitAll();
        http.formLogin().permitAll();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){


        return (web -> web.ignoring().antMatchers("/userLogin/**"));
    }

}
