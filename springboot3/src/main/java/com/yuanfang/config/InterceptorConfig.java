package com.yuanfang.config;

import com.yuanfang.interceptors.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/17
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 配置拦截器相关方法
     * @param registry 拦截器对象
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()) //指定拦截器
                .addPathPatterns("/**") //指定拦截路径：拦截所有
                .excludePathPatterns("file/**") //排除哪些路径
                .order(1); //指定拦截器执行顺序 int 类型数字: 默认按照自然排序执行  数字相同时,按照配置顺序执行
    }
}
