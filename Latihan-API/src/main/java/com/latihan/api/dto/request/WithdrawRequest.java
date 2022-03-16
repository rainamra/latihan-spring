package com.latihan.api.dto.request;

import lombok.Data;

@Data
public class WithdrawRequest {
    private Integer idUser;
    private String userName;
    private String passwordUser;
    private Long amount;
}
