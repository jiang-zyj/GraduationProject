package com.zyj.spring.Test;

import com.zyj.spring.annotation.controller.UserController;
import com.zyj.spring.annotation.dao.impl.UserDaoImpl;
import com.zyj.spring.annotation.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AnnotationTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 15:12
 * @Description: com.zyj.spring.Test
 * @version: 1.0
 */
public class AnnotationTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
//        UserController userController = context.getBean("userController", UserController.class);
//        System.out.println(userController);

        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userServiceImpl);

        UserDaoImpl userDaoImpl = context.getBean("userDaoImpl", UserDaoImpl.class);
        System.out.println(userDaoImpl);


//        userController.register();

    }

}
