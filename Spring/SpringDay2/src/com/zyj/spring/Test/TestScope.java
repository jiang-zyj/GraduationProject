package com.zyj.spring.Test;

import com.zyj.spring.scope.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestScope
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 11:23
 * @Description: com.zyj.spring.scope.Test
 * @version: 1.0
 */
public class TestScope {
    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static void main(String[] args) {
        // 测试单例
//        testSingleton();
        // 测试原型（多例）
        testProtoType();
    }

    private static void testProtoType() {
        Car car1 = context.getBean("car1", Car.class);
        Car car2 = context.getBean("car1", Car.class);
        System.out.println(car1 == car2);
//        System.out.println(car1);
    }

    private static void testSingleton() {
        Car car1 = context.getBean("car", Car.class);
        Car car2 = context.getBean("car", Car.class);
        System.out.println(car1 == car2);       // true;
    }

}
