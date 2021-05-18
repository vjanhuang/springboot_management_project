package com.example.huang_ms.controller;

import com.example.huang_ms.domain.User;
import com.example.huang_ms.mapper.UserMapper;
import com.example.huang_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    //user列表展示,mybatis
    @GetMapping("/view/user")
    public String queryUserList(Model model, HttpServletRequest request){
        List<User> userList = userMapper.queryUserList();
        String isSuccess = request.getParameter("isSuccess");
        model.addAttribute("isSuccess",isSuccess);
        model.addAttribute("users",userList);
        return "view/userlist";
    }
    //添加操作
    @GetMapping("/view/add_user")
    public String add_user(){
     return "view/adduser";
    }
    @PostMapping("/adduser")
    public String addUser(@RequestParam("user_name")String user_name,
                          @RequestParam("email")String email,
                          @RequestParam("phone_number")String phone_number,
                          @RequestParam("gender")int gender,
                          @RequestParam("account")String account,
                          @RequestParam("password")String password,
                          RedirectAttributes redirectAttributes){
        boolean isSuccess;
        User user = new User(user_name,email,phone_number,gender,account,password);
        isSuccess = userService.add(user,account);
        redirectAttributes.addAttribute("isSuccess",isSuccess);
        return "redirect:/view/user";
    }
    //删除操作
    @RequestMapping("/deleteuser/{account}")
    public String deleteUserList(@PathVariable("account")String account){
        userMapper.deleteUser(account);
        return "redirect:/view/user";
    }
    //改动操作
    @RequestMapping("/view/update_user/{account}")
    public String update_user(@PathVariable("account")String account,Model model){
        User user = userMapper.queryUserByAccount(account);
        model.addAttribute("user",user);
        return "view/updateuser";
    }
    @PostMapping("/updateuser")
    public String updateUserList(@RequestParam("user_name")String user_name,
                                 @RequestParam("email")String email,
                                 @RequestParam("phone_number")String phone_number,
                                 @RequestParam("gender")int gender,
                                 @RequestParam("account")String account,
                                 @RequestParam("password")String password){
        User user = new User(user_name,email,phone_number,gender,account,password);
        userMapper.updateUser(user);
        return "redirect:/view/user";
    }
}
