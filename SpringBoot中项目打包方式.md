# SpringBoot中项目打包方式

## war包部署

##### 	设置打包方式为war

> 		**<packaging>war</packaging>**

##### 	在插件中指定入口类

```xml
<build>
	<plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <!--使用热部署出现中文乱码解决方案-->
        <configuration>
          <fork>true</fork>
          <!--增加jvm参数-->
          <jvmArguments>-Dfile.encoding=UTF-8</jvmArguments>
          <!--指定入口类-->
          <mainClass>com.baizhi.Application</mainClass>
        </configuration>
      </plugin>
    </plugins>
</build>	  
```

##### 	排除内嵌的tomcat

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
  <scope>provided</scope>   <!--去掉内嵌tomcat-->
</dependency>

<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
  <scope>provided</scope>  <!--去掉使用内嵌tomcat解析jsp-->
</dependency>
```

##### 	配置入口类

```java
//1.继承SpringBootServletInitializer
//2.覆盖configure方法
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
```

##### 	打包测试

```markdown
# 一旦使用war包部署注意:
-	1. application.yml 中配置port context-path 失效
-	2. 访问时使用打成war包的名字和外部tomcat端口号进行访问项目
```

## Jar包部署

##### 	设置打包方式为jar

> 		**<packaging>jar</packaging>**

**`注意:默认方式也是jar`**

- **`注意:springboot部署jsp时,插件版本必须指定为1.4.2版本,并进行jsp打包配置才可以,其他版本均不支持!!!`**

##### 修改插件版本

> 在项目的pom.xml配置文件中build标签中修改

```xml
<plugins>
  <!--版本必须为1.4.2版本-->
  <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>1.4.2.RELEASE</version>
  </plugin>
</plugins>
```

##### 指定jsp打包配置

> 在项目的pom.xml配置文件中build标签中加入配置

```xml
<resources>
  <!-- 打包时将jsp文件拷贝到META-INF目录下-->
  <resource>
    <!-- 指定resources插件处理哪个目录下的资源文件 -->
    <directory>src/main/webapp</directory>
    <!--指定必须要放在此目录下才能被访问到-->
    <targetPath>META-INF/resources</targetPath>
    <includes>
      <include>**/**</include>
    </includes>
  </resource>
  <resource>
    <directory>src/main/resources</directory>
    <includes>
      <include>**/**</include>
    </includes>
    <filtering>false</filtering>
  </resource>
</resources>
```

##### 重新打包测试即可