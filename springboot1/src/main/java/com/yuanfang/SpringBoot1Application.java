package com.yuanfang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SpringBoot1Application
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
//入口类，启动springboot项目
@SpringBootApplication
public class SpringBoot1Application {
    public static void main(String[] args) {
        //启动SpringBoot应用， 参数1：指定入口类的对象  .class；参数2：main函数参数
        SpringApplication.run(SpringBoot1Application.class,args);
    }

}
