## CORS 跨域

##### CORS

- 	`CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）`。

- 	它允许浏览器向跨源服务器，发出XMLHttpRequest(ajax)请求，从而克服了AJAX只能`同源使用的限制`。

##### 同源策略

- 	**`同源策略`**[same origin policy]是浏览器的一个安全功能，不同源的客户端脚本在没有明确授权的情况下，不能读写对方资源。 同源策略是浏览器安全的基石。

##### 源

- 	**`源`**[origin]就是协议、域名和端口号。例如：http://www.baidu.com:80这个URL。

##### 同源

- 	若地址里面的`协议、域名和端口号均相同`则属于同源。

```markdown
# 同源举例
- 例如判断下面的URL是否与 http://www.a.com/test/index.html 同源
	http://www.a.com/dir/page.html --------->同源
	http://www.child.a.com/test/index.html ->不同源，域名不相同
	https://www.a.com/test/index.html ------>不同源，协议不相同
	http://www.a.com:8080/test/index.html -->不同源，端口号不相同
```

##### 哪些操作不受同源限制

- 页面中的链接，重定向以及表单提交是不会受到同源策略限制的；

- 跨域资源的引入是可以的。如嵌入到页面中的`<script src="..."></script>`，`<img>`，`<link>`，`<iframe>`等。

##### 哪些操作受到同源限制

- 在浏览器中发起一个AJAX请求,会受到同源策略限制。
- **`出现错误:Access-Control-Allow-Origin`**

##### 使用CORS解决同源限制

1. ###### @CrossOrigin注解

   ```java
   @RestController
   @RequestMapping("demos")
   @CrossOrigin
   public class DemoController {
       @GetMapping
       public String demos() {
           System.out.println("========demo=======");
           return "demo ok";
       }
   }
   ```

   

2. ###### 全局解决跨域问题

   ```java
   @Configuration
   public class CorsConfig {
       @Bean
       public CorsFilter corsFilter() {
           UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
           CorsConfiguration corsConfiguration = new CorsConfiguration();
           corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
           corsConfiguration.addAllowedHeader("*"); // 2允许任何头
           corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
           source.registerCorsConfiguration("/**", corsConfiguration);//4处理所有请求的跨域配置
        return new CorsFilter(source);
       }
   }
   ```

   -----