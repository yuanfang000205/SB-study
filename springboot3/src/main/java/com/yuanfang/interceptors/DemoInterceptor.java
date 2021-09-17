package com.yuanfang.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName DemoInterceptor
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/17
 **/
public class DemoInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(DemoInterceptor.class);
    /*
     * @param handler 当前请求的控制器方法对象
     * @param modelAndView 当前请求访问方法的modelAndView对象
     * @param ex 当前请求对象
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("handler: {} ", handler);
        log.debug("==========1=========");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("modelAndView: {} ", modelAndView);
        log.debug("==========2=========");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("==========3=========");
    }
}
