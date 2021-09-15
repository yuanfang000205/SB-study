package com.yuanfang.dao;

import com.yuanfang.entity.User;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/14
 **/
public interface UserDAO {
    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    User findUserByName(String username);

    /**
     * 注册用户
     * @param user 用户信息
     */
    void save(User user);
}
