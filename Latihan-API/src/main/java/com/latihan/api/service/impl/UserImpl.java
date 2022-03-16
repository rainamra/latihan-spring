package com.latihan.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.latihan.api.constant.validator.UserValidator;
import com.latihan.api.dto.request.BalanceCheckRequest;
import com.latihan.api.dto.request.RegisterRequest;
import com.latihan.api.dto.request.WithdrawRequest;
import com.latihan.api.dto.response.BalanceCheckResponse;
import com.latihan.api.dto.response.RegisterResponse;
import com.latihan.api.dto.response.WithdrawResponse;
import com.latihan.api.model.User;
import com.latihan.api.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserValidator userValidator;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws Exception {
        
        User user = new User();

        userValidator.nameExisted(registerRequest);
        user = mapper.map(registerRequest, User.class);
        user.setSaldo(300000L);
        userRepository.save(user);

        RegisterResponse responseUser = mapper.map(user, RegisterResponse.class);

        return responseUser;
    }

    public WithdrawResponse withdraw(WithdrawRequest withdrawRequest) {

        User exist = userRepository.getById(withdrawRequest.getIdUser());

        User user = new User();

        user = mapper.map(withdrawRequest, User.class);
        user.setSaldo(exist.getSaldo() - withdrawRequest.getAmount());
        userRepository.save(user);

        WithdrawResponse responseUser = mapper.map(user, WithdrawResponse.class);

        return responseUser;
    }

    public BalanceCheckResponse balance(BalanceCheckRequest balanceRequest) {
        
        User user = userRepository.getById(balanceRequest.getIdUser());

        BalanceCheckResponse responseUser = mapper.map(user, BalanceCheckResponse.class);

        return responseUser;
    }

    @Override
    public String deleteUser(Integer idUser) {

        try{
            User user = userRepository.findByidUser(idUser);
            userRepository.delete(user);
        }catch(Exception e){
            return "Delete error";
        }
       
        return "Delete success";
    }

    @Override
    public List<RegisterResponse> getUsers() {
        
        List<RegisterResponse> results = new ArrayList<RegisterResponse>();
        List<User> users = userRepository.findAll();
        
        for(int i = 0; i < users.size(); i++){
            results.add(mapper.map(users.get(i), RegisterResponse.class));
        }

        return results;
    }

    @Override
    public RegisterResponse updateUser(Integer idUser, RegisterRequest registerRequest) {
        
        User user = new User();

        user = userRepository.findByidUser(idUser);
        user = mapper.map(registerRequest, User.class);

        Long saldoTemp = user.getSaldo();
        user.setSaldo(saldoTemp);
        userRepository.save(user);

        RegisterResponse response = mapper.map(user, RegisterResponse.class);

        return response;
    }

    // public RegisterResponse updateUser(Integer idUser, RegisterRequest registerRequest) {

    //     User user = new User();

    //     user = userRepository.findByidUser(idUser);
    //     user = mapper.map(registerRequest, User.class)
    //     userRepository.save(user);

    //     RegisterResponse response = mapper.map(user, RegisterResponse.class);

    //     return response;
    // }
    
}
