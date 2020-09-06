package com.fonsoft.facediary.service;

import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User authenticate(UserParameter userParameter);
}


