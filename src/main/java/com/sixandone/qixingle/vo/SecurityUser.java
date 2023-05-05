package com.sixandone.qixingle.vo;

import com.sixandone.qixingle.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition:用户认证对象
 * @Autor DELL
 * @Date 2023/5/2 23:49
 **/
public class SecurityUser implements UserDetails {

    private final SysUser sysUser;

    //权限list
    private List<SimpleGrantedAuthority> authorityList;


    public SecurityUser(SysUser sysUser){
        this.sysUser = sysUser;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setAuthorityList(List<SimpleGrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnabled().equals(1);
    }
}
