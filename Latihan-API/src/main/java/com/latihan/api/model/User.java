package com.latihan.api.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="TEST_RAINA_USER")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idUser;
    private String userName;
    private String passwordUser;
    private Long saldo;


}
