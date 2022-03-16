package com.latihan.api.constant;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class ErrorCode {
    public final String USERNAME_ALREADY_EXIST = "Username already exist, choose another username";
    public final String FIELD_NULL = "Field cannot be null";
}
