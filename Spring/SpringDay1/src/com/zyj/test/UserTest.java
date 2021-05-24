package com.zyj.test;

import com.zyj.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UserTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 13:26
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class UserTest {
    public static void main(String[] args) {
        // 获取到 User 对象
        // 1. 创建 Spring 的 IOC 容器对象
        // 在通过 IOC 容器读取 Bean 的实例之前，需要先将 IOC 容器本身实例化
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        // 2. 获取 user 对象
//        User user = (User) ctx.getBean(User.class);
        //expected single matching bean but found 2: user,user1
        User user = (User) ctx.getBean("user");
        // getBean 在 BeanFactory 中重载了，这种方式可以不用强转，推荐使用
        User u = ctx.getBean("user", User.class);
        System.out.println(u);
        // 3.调用方法
        user.sayHello();
        System.out.println(user);
    }
}
