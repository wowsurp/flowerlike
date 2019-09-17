package com.ajs.apppush.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

    private final String username;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String username, String email, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.email = email;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public String getEmail() {
        return email;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
