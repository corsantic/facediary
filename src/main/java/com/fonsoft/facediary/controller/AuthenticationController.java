package com.fonsoft.facediary.controller;

import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fonsoft.facediary.service.UserService;

@RestController
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authenticateUser")
    public User authenticateUser(@RequestBody UserParameter userParameter){

        User result = userService.authenticate(userParameter);
        return result;
    }
}
