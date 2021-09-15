package com.yuanfang.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName InjectionObjectController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
@RestController
@ConfigurationProperties(value = "users")
public class InjectionObjectController {

    private Integer id;
    private String name;
    private Integer age;

    @RequestMapping("inject")
    public String injectObject() {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "injectObject ok";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
