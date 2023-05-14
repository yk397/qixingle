package com.sixandone.qixingle.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @ClassName yk
 * @Descprition: token 认证
 * @Autor DELL
 * @Date 2023/5/11 17:18
 **/
public class MyAuthenticationToken extends AbstractAuthenticationToken {

    /**
     * 主要
     */
    private final Object principal;

    /**
     * 凭据
     */
    private Object credentials;

    public MyAuthenticationToken( Object principal, Object credentials) {
        super((Collection)null);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    public MyAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal, Object credentials) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
    }

    public static MyAuthenticationToken unauthenticated(Object principal, Object credentials) {
        return new MyAuthenticationToken(principal, credentials);
    }
    public static MyAuthenticationToken authenticated(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        return new MyAuthenticationToken(authorities,principal, credentials);
    }

    public Object getCredentials() {
        return this.credentials;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
