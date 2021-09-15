package com.yuanfang.service;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
public interface UserService {

    List<User> findAll();

    void save(User user);
}
