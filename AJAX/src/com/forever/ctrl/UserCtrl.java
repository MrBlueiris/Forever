package com.forever.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forever.pojo.User;
import com.forever.service.impl.UserServiceImpl;


@RestController
public class UserCtrl {
	@Autowired
	UserServiceImpl userServoceImpl;
	
	@RequestMapping("getAllUser")
	public List<User> getAllUser() {
		
		List<User> allUser = userServoceImpl.getAllUser();
		
		return allUser;
	}
}
