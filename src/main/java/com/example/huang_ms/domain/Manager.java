package com.example.huang_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    //id
    private int id;
    //manager account
    private String account;
    //manager password
    private String password;
}
