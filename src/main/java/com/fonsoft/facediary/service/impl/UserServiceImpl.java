package com.fonsoft.facediary.service.impl;

import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import com.fonsoft.facediary.repository.UserRepository;
import com.fonsoft.facediary.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//
//
//
//    public boolean validateUserInfo(String userName, String userPassword){
//        User user = userRepository.findById()

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticate(UserParameter userParameter) {
        return userRepository.authenticate(userParameter);
    }
}
