package com.yuanfang.controller;

import com.yuanfang.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/27
 **/
@RestController
@RequestMapping("v1/users")
public class UserController {

    //HttpStatus 查看网络状态码
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 查询单个用户
     * @param id 用户id
     * @return 用户user
     */
    //@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")  //@RequestMapping:子类注解 使用GETMapping代表只能使用GET方式访问到当前请求
    //PathVariable:代表在路径中获取请求参数
    //ResponseBody:将控制器方法返回值转回json
    public ResponseEntity<User> user(@PathVariable("id") Integer id){
        log.info("本次id：{}",id);
        User user = new User(12,"建军",56.9);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 返回用户列表
     * @return
     */
    @GetMapping
    public ResponseEntity<List<User>> users(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(111,"小陈",56.9));
        users.add(new User(30,"黑子",16.9));
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    /**
     * 添加用户
     * @param user 用户信息
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody User user){
        log.info("name:{} score:{}",user.getName(),user.getScore());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 更新用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id,@RequestBody User user){
        log.info("本次id：{}",id);
        log.info("name:{} score:{}",user.getName(),user.getScore());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){

        log.info("本次删除id：{}",id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
