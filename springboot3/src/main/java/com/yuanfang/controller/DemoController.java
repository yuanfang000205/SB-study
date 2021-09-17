package com.yuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/17
 **/
@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("test")
    public String demoTest(){
        return "demo";
    }
}
