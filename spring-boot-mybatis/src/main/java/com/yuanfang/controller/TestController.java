package com.yuanfang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
@RestController
public class TestController {
    @RequestMapping("test")
    public String test() {
        return "devtools ok";
    }
}
