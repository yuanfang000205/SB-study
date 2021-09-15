package com.yuanfang;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceTests
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/13
 **/
public class UserServiceTests extends BasicTest{

    @Resource
    private UserService userService;

    @Test
    public void testFindAll() {
        userService.findAll().forEach(System.out::println);
    }

    @Test
    public void testSave(){
        userService.save(new User(null,"小明",50));
    }
}
