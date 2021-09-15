package com.yuanfang.service.impl;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(User user) {
        log.debug("id：{}===》姓名：{}===》年龄：{}" , null,user.getName(),user.getAge());
        userDAO.save(user);
    }
}
