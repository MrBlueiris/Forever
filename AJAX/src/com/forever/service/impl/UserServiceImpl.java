package com.forever.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forever.dao.UserDao;
import com.forever.pojo.User;
import com.forever.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUser() {
		List<User> allUser = userDao.getAllUser();
		return allUser;
	}

}
