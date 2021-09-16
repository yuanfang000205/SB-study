package com.yuanfang.service;

import com.yuanfang.entity.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/14
 **/
public interface UserService {
    /**
     * 用户注册
     */
    void register(User user);


    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User login(String username, String password);
}
