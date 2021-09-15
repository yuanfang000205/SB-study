# SpringBoot 整合Mybatis

## 1)导入相关依赖

* ```xml
  <!--mysql-->
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
  </dependency>
  <!--druid-->
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.19</version>
  </dependency>
  <!--mybatis-spring-boot-starter-->
  <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>2.1.1</version>
  </dependency>
  ```

## 2)整合Mybatis相关配置

* ```yml
  spring:
    datasource:
      type: com.alibaba.druid.pool.DruidDataSource
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3333/bootssm?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
      username: root
      password: root
  mybatis:
    mapper-locations: classpath:com/yuanfang/mapper/*.xml  #指定mapper配置文件位置
    type-aliases-package: com.yuanfang.entity  #指定实体类的别名 默认：类名首字母小写
  ```

* 入口类添加@MapperScan("com.yuanfang.dao"):扫描dao所在包

