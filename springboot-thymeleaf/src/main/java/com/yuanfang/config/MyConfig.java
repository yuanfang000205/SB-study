package com.yuanfang.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyConfig
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/29
 **/
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置请求和页面视图映射
        registry.addViewController("/hello").setViewName("hello");
    }
}
