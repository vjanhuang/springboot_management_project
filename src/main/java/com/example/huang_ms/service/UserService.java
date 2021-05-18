package com.example.huang_ms.service;

import com.example.huang_ms.domain.User;
import com.example.huang_ms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    public boolean add(User user, String account){
        boolean isEmpty = StringUtils.isEmpty(userMapper.queryUserByAccount(account));
        try {
            if(isEmpty){
                userMapper.addUser(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isEmpty;
    }
}
