package com.yuanfang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

/**
 * @ClassName BeanConfig
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/12
 **/
@Configuration //相当于spring.xml，用于创建多个对象的使用,只能用在类上
public class BeanConfig {

    /**
        推荐方法名为返回值的首字母小写，代表当前创建对象在工厂中名称
        可以用在方法上或注解上
     */
    @Bean
    public Calendar calendar() {
        return Calendar.getInstance();
    }
}
