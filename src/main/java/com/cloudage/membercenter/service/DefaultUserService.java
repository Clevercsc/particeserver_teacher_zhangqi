package com.cloudage.membercenter.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IUserRepository;

@Component
@Service
@Transactional
public class DefaultUserService implements IUserService {

	@Autowired
	IUserRepository userRepo;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);//???????
	}

	@Override
	public void login(String account, String passwordHash) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword(String newPasswordHash) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User create(String account, String passwordHash) {
		User user = new User();
		 		user.setAccount(account);
			user.setPasswordHash(passwordHash);
		 		
				return userRepo.save(user);
	}

	@Override
	public User findByAccount(String account) {
	return userRepo.findByAccount(account);
	}





}
