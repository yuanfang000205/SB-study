package com.yuanfang;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceTests
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
public class UserDaoTests extends BasicTest{

    @Resource
    private UserDAO userDAO;

    @Test
    public void testFindAll() {
        userDAO.findAll().forEach(System.out::println);
    }

}
