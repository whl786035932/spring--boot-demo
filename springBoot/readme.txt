在这里我重点讲述mysql、spring data jpa的使用，其中mysql 就不用说了大家很熟悉，jpa是利用Hibernate生成各种自动化的sql，如果只是简单的增删改查，基本上不用手写了，spring内部已经帮大家封装实现了。

1、添加相jar包
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    
    
    
    
    Redis是目前业界使用最广泛的内存数据存储。相比memcached，Redis支持更丰富的数据结构，例如hashes, lists, sets等，同时支持数据持久化。除此之外，Redis还提供一些类数据库的特性，比如事务，HA，主从库。可以说Redis兼具了缓存系统和数据库的一些特性，因此有着丰富的应用场景



1.读取配置文件
读取配置文件的几种方式，applicaiton.properties里的配置不会被覆盖，
@PropertySouce(value="config/db-config.properties") 读取指定目录下的配置文件，只支持properties文件，不支持yml文件
@ConfigurationProperties(prefix="info") 读取applicaiton.properties配置文件，根据prefix 区分
@value("${db.username}") 读取application.properties配置文件
Enviroment 读取环境变量
2. 自动配置原理
 读取META-INFO 文件下的spring.factories 里的配置的类，然后根据里面的配置查看类路径下自动加载该配置类

3. spring boot启动器
spring boot的启动器是包含了一系列可以集成到应用中的依赖包，启动器的命名规则是Spring Boot官方的启动器都是以spring-boot-starter-命名的，代表了一个特定的应用类型。

第三方的启动器不能以spring-boot开头命名，它们都被Spring Boot官方保留。一般一个第三方的应该这样命名，像mybatis的mybatis-spring-boot-starter。

4. spring boot启动前需要加载代码
自定义实现ApplicationRunner 或是CommandlineRunner
5. spring boot的核心注解
springboot的核心注解是@SpringBootApplication ,它主要包含了以下三个注解
   1.@SpringBootConfiguratin, :组合了@Configuration, 实现了配置文件的功能
   2.@EnableAutoConfiguration :开启自动配置的功能，也可以关闭自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。
   3.@ComponentScan:spring的组件扫描
   



