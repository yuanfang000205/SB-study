package com.yuanfang.controller;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import com.yuanfang.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/22
 **/
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        //生成4位随机数字
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //保存至session作用域
        session.setAttribute("code",code);
        //设置响应类型
        response.setContentType("image/png");
        //通过response响应图片
        ServletOutputStream os = response.getOutputStream();
        //生成图片
        VerifyCodeUtils.outputImage(220,60,os,code);
    }

    @RequestMapping("register")
    public String register(User user, String code,HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到验证码: {}",code);
        log.debug("用户名:{}, 真实姓名:{}, 密码:{}, 性别:{}",user.getUsername(),user.getRealname(),user.getPassword(),user.getGender());
        try {
            //判断用户输入的验证码与session中验证码是否一致
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)){
                throw new RuntimeException("验证码错误，请重新输入！！！");
            }
            //进行用户注册
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/register?msg="+ URLEncoder.encode(e.getMessage(),"UTF-8");
        }
        return "redirect:/login";
    }


    /**
     * 用户登录
     * @return
     */
    @RequestMapping("login")
    public String login(String username,String password,HttpSession session) throws UnsupportedEncodingException {
        log.debug("用户名：{} 密码： {}",username,password);
        try {
            //调用业务层进行登录
            User user = userService.login(username, password);
            //保存用户登录标记至session
            session.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login?msg" + URLEncoder.encode(e.getMessage(),"UTF-8");
        }

        return "redirect:/employee/lists";
    }
}
