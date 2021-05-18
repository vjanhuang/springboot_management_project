package com.example.huang_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    //id
    private int id;
    //项目名
    private String project_name;
    //项目负责人，与用户数据相关
    private String project_leader;
    //负责人联系方式，与用户数据相关
    private String phone_number;
    //负责人联系方式，与用户数据相关
    private String email;
    //项目注册时间
    private Date login_date;
}
