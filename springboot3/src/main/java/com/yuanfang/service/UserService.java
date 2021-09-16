package com.yuanfang.service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/16
 **/
public interface UserService {

    String find(String name);
    void save(String name);
    void delete(Integer id);
}
