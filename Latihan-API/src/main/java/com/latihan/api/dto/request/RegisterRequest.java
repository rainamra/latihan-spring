package com.latihan.api.dto.request;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class RegisterRequest {

    @NotNull(message= "field cannot be null")
    private String userName;
    private String passwordUser;
}
