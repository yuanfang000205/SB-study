# SpringBoot启动流程

## 主类添加@SpringBootApplication注解

​	**该注解由以下三个注解组成**

* @Configuration  =========配置类注解
* @ComponentScan =======配置一个扫包器
* @EnableAutoConfiguration  由以下两个注解构成
  * @AutoConfigurationPackage：用来解析当前类所在的包名，并把包名赋值给上面的扫包器
  * @Import：主要功能是为了实现自动配置

## 在添加以上注解的类中调用class

* ```java
  SpringApplication.run(SpringnameApplication.class, args);
  ```

  