package com.zyj.test;

import com.zyj.DI.Car;
import com.zyj.FactoryBean.CarFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName CarFactoryBeanTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 20:10
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class CarFactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car = context.getBean("carFactoryBean", Car.class);
        System.out.println(car);
    }

}
