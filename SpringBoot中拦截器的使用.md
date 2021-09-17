# SpringBoot中拦截器的使用

## 自定义一个拦截器

* ```java
  public class DemoInterceptor implements HandlerInterceptor {
      private static final Logger log = LoggerFactory.getLogger(DemoInterceptor.class);
      /*
       * @param handler 当前请求的控制器方法对象
       * @param modelAndView 当前请求访问方法的modelAndView对象
       * @param ex 当前对象出现的异常对象
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
  ```

## 配置拦截器

* ```java
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
  ```





