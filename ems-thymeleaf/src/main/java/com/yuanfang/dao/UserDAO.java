package com.yuanfang.dao;

import com.yuanfang.entity.User;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
public interface UserDAO {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 注册用户
     * @param user
     */
    void save(User user);
}
