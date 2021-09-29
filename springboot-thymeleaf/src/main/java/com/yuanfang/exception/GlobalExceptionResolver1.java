package com.yuanfang.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName GlobalExceptionResolver
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/29
 **/
@Component
class GlobalExceptionResolver1 implements HandlerExceptionResolver {
    /**
     * resolveException：当控制器中任意一个方法出现异常时，若该控制器中的方法没有自己进行异常处理，则进入全局处理
     * @param httpServletRequest   当前请求对象
     * @param httpServletResponse  当前响应对象
     * @param o 当前出现错误的方法对象
     * @param e 出现异常的方法对象
     * @return modelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("这是全局异常处理...");
        System.out.println("当前异常为：" + e);
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof UserNotFoundException){
            modelAndView.setViewName("test");
            return modelAndView;
        }
        modelAndView.setViewName("500");
        return modelAndView;
    }
}
