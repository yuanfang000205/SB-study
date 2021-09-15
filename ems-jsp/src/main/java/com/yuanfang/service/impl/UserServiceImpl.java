package com.yuanfang.service.impl;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/14
 **/
@Service
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
@Transactional
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        //1.根据用户查询数据库是否存在改用户名
        User userDB = userDAO.findUserByName(user.getUsername());
        if (!ObjectUtils.isEmpty(userDB)){
            throw new RuntimeException("用户名已存在，请重新输入用户名");
        }
        //2.进行注册之前给明文加密
        String passwordSecret = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(passwordSecret);
        userDAO.save(user);
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    @Override
    public User login(String username, String password) {
        //1.查询数据库中是否存在该用户,不存在报错,存在继续
        User user = userDAO.findUserByName(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("用户名不存在,请输入正确的用户名");
        }
        //2.判断密码加密后是否与数据库中加密密码一致
        String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(digestPassword)) {
            throw new RuntimeException("密码错误,请输入正确的密码!!!");
        }
        return user;
    }
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
}
