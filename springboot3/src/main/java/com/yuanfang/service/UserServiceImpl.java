package com.yuanfang.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/16
 **/
@Service
public class UserServiceImpl implements UserService{


    @Override
    public String find(String name) {
        System.out.println("调用service层的find方法");
        return name;
    }

    @Override
    public void save(String name) {
        System.out.println("调用service层的save方法");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("调用service层的delete方法");
    }
}
