package com.sixandone.qixingle.config;

import com.sixandone.qixingle.security.JwtCheckFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName yk
 * @Descprition: 安全配置
 * @Autor DELL
 * @Date 2023/5/5 14:07
 **/
@Configuration
public class MyWebSecurityConfig {

    @Resource
    private JwtCheckFilter jwtCheckFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.addFilterBefore(jwtCheckFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests()
                .mvcMatchers("/wx/user/{appid}/**")
                .permitAll()
                .anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){


        return (web -> web.ignoring().antMatchers("/wx/user/{appid}/**"));
    }

}
