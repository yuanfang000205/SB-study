package com.yuanfang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAdvice
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/16
 **/
//指定运行时生效
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAdvice {
}
