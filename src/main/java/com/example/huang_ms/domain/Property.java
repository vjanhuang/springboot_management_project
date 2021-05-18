package com.example.huang_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    //id
    private int id;
    //license code
    private String license_code;
    //Mac地址
    private String mac_address;
    //ip地址
    private String ip_address;
    //所属项目，与项目数据相关
    private String project_name;
}
