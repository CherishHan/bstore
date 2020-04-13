package com.brayden.bstore.service.impl;

import com.brayden.bstore.entity.ResponseData;
import com.brayden.bstore.entity.User;
import com.brayden.bstore.mapper.UserMapper;
import com.brayden.bstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseData register(User user) {
        user.setUuid(UUID.randomUUID().toString());
        user.setCreatedTime(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int insert = userMapper.insert(user);
        return new ResponseData(20000, "Success", "register");
    }
}
