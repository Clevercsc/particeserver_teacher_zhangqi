package com.cloudage.membercenter.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IUserService;

@RestController
@RequestMapping("/api")
public class APIController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		return "HELLO WORLD";
	}

	@Autowired
	IUserService iUserService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestParam String account, @RequestParam String passwordHash, @RequestParam String email,
			@RequestParam String name, MultipartFile avatar, HttpServletRequest requet) {

		User user = new User();
		user.setAccount(account);
		user.setEmail(email);
		user.setName(name);
		user.setPasswordHash(passwordHash);

		if (avatar != null) {
			String realPath = requet.getSession().getServletContext().getRealPath("WEB-INF/upload");
			try {
				FileUtils.copyInputStreamToFile(avatar.getInputStream(), new File(realPath, account + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setAvatar("upload/" + account + ".png");
		}
		return iUserService.save(user);
	}

	
	/*
	 * d登录操作
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestParam String account, @RequestParam String passwordHash, HttpServletRequest request) {
		User user = iUserService.findByAccount(account);
		//判断用户是否为空并判断密码是否正确
		if (user != null && user.getPasswordHash().equals(passwordHash)) {
			request.getSession().setAttribute("user", user);
			return user;
		} else {
			return null;
		}

	}

	
	//返回当前用户
	@RequestMapping(value = "/me",method = RequestMethod.POST )
	public User getCurrentUser(HttpServletRequest request){
		Object object = request.getSession().getAttribute("user");
		if(object instanceof User){//判断object是否为User 的实例,是返回User类型的object,不是返回null
			return (User) object;
		}
		else{
			return null;
		}
	}
}
