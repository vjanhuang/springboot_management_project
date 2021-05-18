package com.example.huang_ms.mapper;

import com.example.huang_ms.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper{
    List<User> queryUserList();
    User queryUserByAccount(String account);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(String account);
}
