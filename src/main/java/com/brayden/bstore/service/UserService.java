package com.brayden.bstore.service;

import com.brayden.bstore.entity.ResponseData;
import com.brayden.bstore.entity.Account;

public interface UserService {

    ResponseData register(Account user);

    Account getUserByName(String phone);
}
