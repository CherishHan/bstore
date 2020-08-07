package com.brayden.bstore.authentication;

import com.brayden.bstore.entity.User;
import com.brayden.bstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static java.lang.String.format;

@Component
public class AccountDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);
        if(StringUtils.isEmpty(user)){
            throw new UsernameNotFoundException(format("User %s not found!", s));
        }
        logger.info("user: {}, password: {}", user.getName(), user.getPassword());
        AuthUser authUser = new AuthUser();
        authUser.setUser(user);
        return authUser;
    }
}
