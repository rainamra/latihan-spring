package com.latihan.api.dto.request;

import lombok.Data;

@Data
public class BalanceCheckRequest {
    private Integer idUser;
    private String password;
}
