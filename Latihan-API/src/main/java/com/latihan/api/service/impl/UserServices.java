package com.latihan.api.service.impl;

import java.util.List;

import com.latihan.api.dto.request.BalanceCheckRequest;
import com.latihan.api.dto.request.RegisterRequest;
import com.latihan.api.dto.request.WithdrawRequest;
import com.latihan.api.dto.response.BalanceCheckResponse;
import com.latihan.api.dto.response.RegisterResponse;
import com.latihan.api.dto.response.WithdrawResponse;

public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest) throws Exception;
    String deleteUser(Integer idUser);
    List<RegisterResponse> getUsers(); 
    RegisterResponse updateUser(Integer idUser, RegisterRequest registerRequest);

    WithdrawResponse withdraw(WithdrawRequest withdrawRequest);
    BalanceCheckResponse balance(BalanceCheckRequest balanceRequest);
    // BalanceCheckResponse delete(DeleteRequest deleteRequest);
}
