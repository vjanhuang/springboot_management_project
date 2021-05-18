package com.example.huang_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    //用户名字
    private String user_name;
    //用户信息,email
    private String email;
    //用户信息，联系电话
    private String phone_number;
    //用户性别
    private int gender;
    //账号,primary key
    private String account;
    //密码
    private String password;
    //构造方法
}
