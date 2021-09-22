package com.yuanfang.controller;

import com.yuanfang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/19
 **/
@Controller
@RequestMapping("demo")
public class DemoController {

    /**
     * 测试thymeleaf使用
     * @return
     */
    @RequestMapping("test")
    public String test() {
        System.out.println(" ok");
        return "test";
    }

    /**
     *
     * @param request forward跳转时使用request请求域，redirect使用session请求域
     * @param model
     * @return
     */
    @RequestMapping("testData")
    public String testData(HttpServletRequest request, Model model){
        /* 测试单个数据*/
        String name = "陈建军";
        Integer age = 18;
        String href = "<a href='http://www.taobao.com'>淘宝一下</a>";
        User user = new User(12, "田寅", 5600.63, new Date());
        List<User> users = Arrays.asList(
                new User(13, "陈建军", 5600.63, new Date()),
                new User(12, "田寅", 5600.63, new Date()));
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        model.addAttribute("h",href);
        request.setAttribute("user",user);
        model.addAttribute("users",users);
        return "demo";
    }

}
