package com.labinvent.task.web.security;


import com.labinvent.task.serivice.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserAuthentication implements Authentication {

    private boolean authenticated;
    private UserDTO principal;
    private List<GrantedAuthority> authorities;

    public UserAuthentication(boolean authenticated, UserDTO principal, List<GrantedAuthority> authorities) {
        this.authenticated = authenticated;
        this.principal = principal;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return principal.getEmail();
    }

    public void setPrincipal(UserDTO principal) {
        this.principal = principal;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
