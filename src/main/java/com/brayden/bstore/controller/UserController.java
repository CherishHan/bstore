package com.brayden.bstore.controller;

import com.brayden.bstore.entity.Buser;
import com.brayden.bstore.entity.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseData login(@RequestBody Buser user) {
        logger.info("username: {}, password: {}", user.getUsername(), user.getPassword());
        return new ResponseData(20000, "Success", UUID.randomUUID().toString());
    }

    @PostMapping("/logout")
    public ResponseData logout(){
        return new ResponseData(20000, "logout Success", UUID.randomUUID().toString());
    }
}
