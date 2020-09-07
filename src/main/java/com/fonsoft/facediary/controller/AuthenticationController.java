package com.fonsoft.facediary.controller;

import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fonsoft.facediary.service.UserService;

@RestController
public class AuthenticationController {

    private final UserService userService;
    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authentication")
    public User authenticateUser(@RequestBody  UserParameter userParameter){

        return userService.authenticate(userParameter);
    }
}
