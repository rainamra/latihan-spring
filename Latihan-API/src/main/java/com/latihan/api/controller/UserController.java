package com.latihan.api.controller;

import java.util.List;

import com.latihan.api.dto.request.BalanceCheckRequest;
import com.latihan.api.dto.request.RegisterRequest;
import com.latihan.api.dto.response.BalanceCheckResponse;
import com.latihan.api.dto.response.RegisterResponse;
import com.latihan.api.exception.UserException;
import com.latihan.api.service.impl.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("")
    public ResponseEntity<RegisterResponse> register(@Validated @RequestBody RegisterRequest registerRequest, BindingResult validator) throws Exception {
        if(validator.hasErrors()){
            throw new UserException(validator.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<RegisterResponse>(userServices.register(registerRequest), HttpStatus.CREATED);
    }

    // @PostMapping("")
    // public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws Exception {
    //     return new ResponseEntity<RegisterResponse>(userServices.register(registerRequest), HttpStatus.CREATED);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceCheckResponse> balance(@PathVariable(value= "id") Integer idUser, 
    @RequestBody BalanceCheckRequest balanceRequest ) {
        return new ResponseEntity<BalanceCheckResponse>(userServices.balance(balanceRequest), HttpStatus.OK);

    }

    // @PutMapping("/withdraw/{id}")
    // public ResponseEntity<WithdrawResponse> withdraw(@PathVariable(value= "id") Integer idUser, 
    // @RequestBody WithdrawRequest withdrawRequest ) {   
    //     return new ResponseEntity<WithdrawResponse>(userServices.withdraw(withdrawRequest), HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value= "id") Integer idUser) {
        return new ResponseEntity<String>(userServices.deleteUser(idUser), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<RegisterResponse>> getUsers() {
        return new ResponseEntity<List<RegisterResponse>>(userServices.getUsers(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterResponse> updateUser(@PathVariable(value= "id") Integer idUser, 
    @RequestBody RegisterRequest RegisterRequest ) {   
        return new ResponseEntity<RegisterResponse>(userServices.updateUser(idUser, RegisterRequest), HttpStatus.OK);
    }

}
