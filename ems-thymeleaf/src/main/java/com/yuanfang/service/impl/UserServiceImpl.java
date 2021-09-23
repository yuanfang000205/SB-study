package com.yuanfang.service.impl;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;
    @Override
    public void register(User user) {
        //通过用户名查询数据库中是否存在该用户
        User userDB = userDAO.findByUserName(user.getUsername());
        if (!ObjectUtils.isEmpty(userDB)){
            throw new RuntimeException("该用户已存在，请重新输入用户名！！！");
        }
        //注册用户之前对用户密码进行加密
        String passwordSecret = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(passwordSecret);
        //不存在则注册新用户
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        //通过用户名查询用户是否存在
        User user = userDAO.findByUserName(username);
        if (ObjectUtils.isEmpty(user)){
            throw new RuntimeException("该用户不存在，请重新输入用户名！！！");
        }
        //对从页面输入的密码进行加密后与数据库中加密密码进行校验
        String secretPwd = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(secretPwd)){
            throw new RuntimeException("密码错误，请重新输入！！！");
        }
        return user;
    }
}
