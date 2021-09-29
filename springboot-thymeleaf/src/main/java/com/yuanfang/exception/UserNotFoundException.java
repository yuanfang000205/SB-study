package com.yuanfang.exception;

import org.springframework.stereotype.Component;

/**
 * @ClassName UserNotFoundException
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/29
 **/
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
