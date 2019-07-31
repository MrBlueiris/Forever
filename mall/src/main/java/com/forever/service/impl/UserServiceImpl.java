package com.forever.service.impl;

import com.forever.auth.entity.UserInfo;
import com.forever.auth.utils.JwtUtils;
import com.forever.auth.utils.RsaUtils;
import com.forever.common.Const;
import com.forever.dao.UserMapper;
import com.forever.pojo.User;
import com.forever.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User login = userMapper.login(user);


        return login;

    }
}
