package com.yuanfang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
@RestController
public class TestController {

    @Autowired
    public Calendar calendar;

    @RequestMapping("test")
    public String test() {
        System.out.println(calendar.getTime());
        return "springboot test";
    }

}
