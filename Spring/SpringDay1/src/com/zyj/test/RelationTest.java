package com.zyj.test;

import com.zyj.relation.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName RelationTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 20:27
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class RelationTest {

    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");


    public static void main(String[] args) {
        // 继承
        abstractTest();
        // 依赖
        dependTest();
    }

    private static void dependTest() {
        Address address3 = context.getBean("address3", Address.class);
        System.out.println(address3);
    }

    private static void abstractTest() {
//        Address address1 = context.getBean("address1", Address.class);
//        System.out.println(address1);

        Address address2 = context.getBean("address2", Address.class);
        System.out.println(address2);
    }

}
