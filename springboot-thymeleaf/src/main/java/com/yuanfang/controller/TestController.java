package com.yuanfang.controller;

import com.yuanfang.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/29
 **/
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello ok");
        int a = 1/0;
        return "hello";
    }

    @RequestMapping("login")
    public String login(String username, String password){
        System.out.println("login...");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        if ("jianjun".equals(username) && "123".equals(password)){
            return "success";
        }else {
            throw new UserNotFoundException("用户不存在！！！请重新输入");
        }
    }
}
