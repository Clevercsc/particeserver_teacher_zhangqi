package com.cloudage.membercenter.service;

import com.cloudage.membercenter.entity.User;

public interface IUserService {
	User save(User user);
	User create(String account, String passwordHash);
	void login(String account, String passwordHash);
	User getCurrentUser();
	boolean changePassword(String newPasswordHash);
	void logout();
	User findByAccount(String account);
}
