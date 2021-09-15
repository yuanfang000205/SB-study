package com.yuanfang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello springboot ...");
        return "hello springboot";
    }
}
