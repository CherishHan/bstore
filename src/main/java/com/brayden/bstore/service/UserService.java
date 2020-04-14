package com.brayden.bstore.service;

import com.brayden.bstore.entity.ResponseData;
import com.brayden.bstore.entity.User;

public interface UserService {

    ResponseData register(User user);

    User getUserByName(String phone);
}
