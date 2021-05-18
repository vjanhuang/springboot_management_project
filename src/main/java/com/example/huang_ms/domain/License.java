package com.example.huang_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class License {
    //id
    private Integer id;
    //license_code
    private String license_code;
    //version
    private String license_version;
    //price
    private int license_price;
    //isValid
    private int validity;
}
