package com.brayden.bstore.authentication;

import com.brayden.bstore.entity.Buser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Buser buser = new Buser();
        buser.setUsername("admin");
        buser.setPassword(new BCryptPasswordEncoder().encode("111111"));
        AuthUser authUser = new AuthUser();
        authUser.setUsername(buser.getUsername());
        authUser.setPassword(buser.getPassword());
        return authUser;
    }
}
