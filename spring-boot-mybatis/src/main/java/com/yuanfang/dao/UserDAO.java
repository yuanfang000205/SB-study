package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
public interface UserDAO {
    /**
     * 查询所有用户
     */
    List<User> findAll();

    /**
     * 保存用户信息
     */
    void save(User user);
}
