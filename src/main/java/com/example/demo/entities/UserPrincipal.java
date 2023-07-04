package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class UserPrincipal implements UserDetails {

	private User user ;
	@Autowired
	public UserPrincipal(User user) {
		this.user =user ;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		this.user.getAuthorities().forEach(p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getAuthoritieName());
			authorities.add(authority) ;		
		});
		
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		try {
			return user.getActive() == 1 ;
		}
		catch (Exception e) {
			return false ;
		}
		
	}

}
