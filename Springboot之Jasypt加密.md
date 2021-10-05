# Springboot之Jasypt加密

## 导入相关依赖

* ```xml
  <dependency>
      <groupId>com.github.ulisesbocchio</groupId>
      <artifactId>jasypt-spring-boot-starter</artifactId>
      <version>2.1.0</version>
  </dependency>
  ```

## 配置yml

* ```yml
  jasypt:
    encryptor:
      algorithm: PBEWithMD5AndDES #默认指定加密方式
      password: cf150b74e4824146ad76e9ebe757ba76 #使用加密秘钥
  ```

## 使用加密解密方法

* ```java
   private StringEncryptor stringEncryptor;
  
      @Autowired
      public JasyptTests(StringEncryptor stringEncryptor) {
          this.stringEncryptor = stringEncryptor;
      }
  
      @Test
      public void testSecret() {
          //加密
          String secret = stringEncryptor.encrypt("root");
          System.out.println(secret);
          //解密
          String decrypt = stringEncryptor.decrypt("zEcilX/9gieZ8iTcNfKwMA==");
          System.out.println(decrypt);
      }
  ```

## 加密配置文件

* 使用程序导入秘钥,更加安全
  * ![image-20211005145207020](C:\Users\WE\AppData\Roaming\Typora\typora-user-images\image-20211005145207020.png)

* 加密数据库账号密码

  * ```yml
    username: ENC(zEcilX/9gieZ8iTcNfKwMA==)
    password: ENC(zEcilX/9gieZ8iTcNfKwMA==)
    ```

* 加密数据库地址

  * ```yml
    mysql:
      host: ENC(+21G/SYV8XrEDI5wCUbNNPacuvowMfuJ)
    spring:
      datasource:
        type: com.alibaba.druid.pool.DruidDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://${mysql.host}:3333/bootssm?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    ```

  

  

  

  

  