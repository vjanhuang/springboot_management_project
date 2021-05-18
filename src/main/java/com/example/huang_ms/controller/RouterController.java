package com.example.huang_ms.controller;

import com.example.huang_ms.domain.User;
import com.example.huang_ms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RouterController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/view/page")
    public String toPage() {
        return "view/page";
    }
    @RequestMapping({"/","/index","/main"})
    public String index(@RequestParam("username") String account, @RequestParam("password") String password, Model model, HttpSession session){
        List<User> list = new ArrayList<User>();
        list = userMapper.queryUserList();
        boolean b = false;
        for (User user:list){
            if(user.getAccount().equals(account)&&user.getPassword().equals(password)){
                b=true;
                break;
            }
        }
        if (b) {
            session.setAttribute("loginUser",account);
            return "index";
        }
        else{
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }
    }
    @RequestMapping({"/login"})
    public String login(){
        return "login";
    }
}
