package io.vcti.springSecurityJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.vcti.springSecurityJpa.entity.User1;
import io.vcti.springSecurityJpa.entity.UserPrincipal;
import io.vcti.springSecurityJpa.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user=repo.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("Username doesnot exist!");
		return new UserPrincipal(user);
	}

}
