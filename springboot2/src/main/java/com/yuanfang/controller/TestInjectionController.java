package com.yuanfang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestInjectionController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
@RestController
public class TestInjectionController {
    @Value("${bir}")
    private Date bir;
    @Value("${lists}")
    private List<String> lists;
    @Value("#{${maps}}")
    private Map<String, String> maps;

    @RequestMapping("testInject")
    public String TestInject() {

        System.out.println("bir = " + bir);
        for (String list : lists) {
            System.out.println(list);
        }
        maps.forEach((key,Value) -> System.out.println("key=" + key + ",value=" + Value ));
        return "testInject ok";
    }
}
