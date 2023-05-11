package com.sixandone.qixingle.service.service.userServiceImpl;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.service.service.SysMenuService;
import com.sixandone.qixingle.service.service.userService;
import com.sixandone.qixingle.vo.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private userService userService;

    @Resource
    private SysMenuService sysMenuService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.queryUserByUserName(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<String> userPermissions = sysMenuService.queryPermissionsByUserOpenId(sysUser.getOpenid());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (String userPermission : userPermissions) {
            authorityList.add(new SimpleGrantedAuthority(userPermission));
        }
        SecurityUser securityUser = new SecurityUser(sysUser);
        securityUser.setAuthorityList(authorityList);
        return securityUser;
    }
}
