package com.yuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JSPController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
@Controller
public class JSPController {

    @RequestMapping("jsp")
    public String test(){
        return "index";
    }
}
