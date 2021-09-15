package com.yuanfang.controller;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("save")
    public void save(User user){
        userService.save(user);
        System.out.println("1111111111");
    }
}
