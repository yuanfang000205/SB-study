package com.yuanfang;

import com.yuanfang.dao.UserDao;
import com.yuanfang.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserDaoTests
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/10/5
 **/
@SpringBootTest
public class UserDaoTests {
    @Resource
    private UserDao userDao;

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        System.out.println(users);
    }
}
