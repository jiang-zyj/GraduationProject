package com.zyj.test;

import com.zyj.DI.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;

/**
 * @ClassName CarTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 16:14
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class CarTest {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
//        Car car = ctx.getBean("car", Car.class);
//        System.out.println(car);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car1 = ctx.getBean("car1", Car.class);
        System.out.println(car1);
        Car car2 = ctx.getBean("car2", Car.class);
        System.out.println(car2);
        reflectTest();
        PTest();
    }

    private static void PTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car3 = ctx.getBean("car3", Car.class);
        System.out.println("car3:" + car3);
    }

    private static void reflectTest() {
        Class<Car> cls = Car.class;
        Constructor[] cons = cls.getDeclaredConstructors();
        for (Constructor con : cons) {
            Class[] types = con.getParameterTypes();
            for (Class type : types) {
                System.out.print(type.getName() + ",");
            }
            System.out.println();
        }
    }

}
