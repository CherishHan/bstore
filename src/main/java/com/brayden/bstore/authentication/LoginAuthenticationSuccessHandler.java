package com.brayden.bstore.authentication;

import com.brayden.bstore.util.JsonResponse;
import com.brayden.bstore.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        logger.info("auth username: {}, password: {}", authUser.getUsername(), authUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("登录成功");
        String token = JwtTokenUtil.generateToken(authUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("username", authUser.getUsername());
        map.put("token", token);
        map.put("code", 20000);
        new JsonResponse().WriteJSON(httpServletRequest, httpServletResponse, map);
    }
}
