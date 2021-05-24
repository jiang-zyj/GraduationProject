package com.zyj.spring.Test;

import com.zyj.spring.lifeCircle.Car;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName LifeCycleTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 11:57
 * @Description: com.zyj.spring.Test
 * @version: 1.0
 */
public class LifeCycleTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println("==> 4. 使用 bean 对象");

        // 关闭容器
        context.close();
    }

}
