package com.yuanfang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionResolver2
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/29
 **/
@ControllerAdvice   //为controller层的控制器添加统一操作
public class GlobalExceptionResolver2 {

    //处理指定异常
    @ExceptionHandler(value = IllegalNumberException.class)
    @ResponseBody
    public ResponseEntity<String> illeaglNumberExceptionHandler(Exception ex){
        System.out.println("进入非法参数异常处理中。。。");
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //处理exception及其子类异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<String> exceptionHandler(Exception ex){
        System.out.println("进入自定义异常处理中。。。");
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
