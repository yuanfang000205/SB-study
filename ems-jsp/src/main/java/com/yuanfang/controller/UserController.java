package com.yuanfang.controller;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import com.yuanfang.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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
 * @Date 2021/9/14
 **/
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 生成验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        //1.生成随机字符串
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.保存随机字符串到Session中
        session.setAttribute("code",code);
        //3.将随机字符串生成图片并通过response响应图片
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(130,60,os,code);
    }

    @RequestMapping("register")
    public String register(User user, String code,HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到验证码: {}",code);
        log.debug("用户名:{}, 真实姓名:{}, 密码:{}, 性别:{}",user.getUsername(),user.getRealname(),user.getPassword(),user.getGender());
        try {
            //判断验证码是否正确
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) {
                throw new RuntimeException("验证码输入错误!");
            }
            //判断完之后进行用户注册
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/regist.jsp?msg="+ URLEncoder.encode(e.getMessage(),"UTF-8");
        }
        return "redirect:/login.jsp";
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

    @RequestMapping("login")
    public String login(String username,String password,HttpSession session) throws UnsupportedEncodingException {
        try {
            //执行登录业务逻辑
            User user = userService.login(username,password);
            //登录成功,保存用户登录标记
            session.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login.jsp?msg=" + URLEncoder.encode(e.getMessage(),"UTF-8");
        }

        return "redirect:/employee/list";
    }
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
}
