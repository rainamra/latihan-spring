package com.latihan.api.dto.response;

import lombok.Data;

@Data
public class BalanceCheckResponse {
    private Integer idUser;
    private String userName;
    private Long saldo;
}
