package io.vcti.springSecurityJpa.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	private User1 user;

	public UserPrincipal(User1 user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		System.out.println("Role assigned: " + "ROLE_" + user.getRole().toUpperCase());
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

}
