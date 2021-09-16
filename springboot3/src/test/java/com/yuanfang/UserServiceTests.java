package com.yuanfang;

import com.yuanfang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceTests
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/16
 **/
public class UserServiceTests extends BasicTests{

    @Autowired
    private UserService userService;


    @Test
    public void testFind(){
        String name = userService.find("陈建军");
        System.out.println(name);
    }

    @Test
    public void testSave(){
        userService.save("chen sir");
    }

    @Test
    public void testDelete(){
        userService.delete(111);
    }
}
