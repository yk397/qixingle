package com.sixandone.qixingle.service.userService.userServiceImpl;

import com.sixandone.qixingle.service.userService.SysMenuService;
import com.sixandone.qixingle.service.userService.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName yk
 * @Descprition:用户安全服务，继承springboot提供的UserDetailsService
 * @Autor DELL
 * @Date 2023/5/3 0:04
 **/
@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
