package io.vcti.springSecurityJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.vcti.springSecurityJpa.entity.User1;
import io.vcti.springSecurityJpa.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public void saveUser(User1 user) {
		repo.save(user);
	}

	public List<User1> findAllUsers() {
		return repo.findAll();
	}

}
