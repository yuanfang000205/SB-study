package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/10/5
 **/
public interface UserDao {
    List<User> findAll();
}

