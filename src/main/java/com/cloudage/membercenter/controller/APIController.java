package com.cloudage.membercenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IUserService;

@RestController
@RequestMapping("/api")
public class APIController {

	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public @ResponseBody String hello(){
		return "HELLO WORLD";
	}
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping(value= "/register" ,method =RequestMethod.POST)
	public User register(
		@RequestParam String account,
		@RequestParam String passwordHash,
		@RequestParam String email,
		@RequestParam String name){
		
		User user =new User();
		user.setAccount(account);
		user.setEmail(email);
		user.setName(name);
		user.setPasswordHash(passwordHash);
		return iUserService.save(user);
	}
	
}
