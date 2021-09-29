package com.yuanfang.controller;

import com.yuanfang.exception.IllegalNumberException;
import com.yuanfang.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> demo(@PathVariable("id") Integer id){
        System.out.println("demo is ok:" + id);
        if (id < 0) {
            throw new IllegalNumberException("无效id，请重新输入！！！");
        }
        return new ResponseEntity<>("demo ok" , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
