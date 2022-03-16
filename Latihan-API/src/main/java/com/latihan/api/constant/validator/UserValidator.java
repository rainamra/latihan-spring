package com.latihan.api.constant.validator;

import com.latihan.api.constant.ErrorCode;
import com.latihan.api.dto.request.RegisterRequest;
import com.latihan.api.exception.UserException;
import com.latihan.api.model.User;
import com.latihan.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    ErrorCode errorCode;
        
    public void nameExisted(RegisterRequest registerRequest) throws Exception {
        User user = userRepo.findByuserName(registerRequest.getUserName());
        if(user != null) {
            throw new UserException(errorCode.getUSERNAME_ALREADY_EXIST());
        }


    }
}
