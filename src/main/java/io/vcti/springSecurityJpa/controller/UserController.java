package io.vcti.springSecurityJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vcti.springSecurityJpa.entity.User1;
import io.vcti.springSecurityJpa.service.UserServiceImpl;

@RestController
@RequestMapping("/sec")
public class UserController {
	
	@Autowired
	public UserServiceImpl service;
	
	@Autowired
	public BCryptPasswordEncoder encoder;

	@PostMapping("/save")
	public ResponseEntity<?> addUser(@RequestBody User1 user)
	{
		String pw=user.getPwd();
		String newPw=encoder.encode(pw);
		user.setPwd(newPw);
		service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully!");
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<User1>> fetchUSer()
	{
		return ResponseEntity.ok(service.findAllUsers());
	}
}
