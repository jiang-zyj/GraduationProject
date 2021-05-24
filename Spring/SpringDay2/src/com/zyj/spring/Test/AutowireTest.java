package com.zyj.spring.Test;

import com.zyj.spring.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AutowireTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 14:40
 * @Description: com.zyj.spring.Test
 * @version: 1.0
 */
public class AutowireTest {

    public static void main(String[] args) {
        // 测试自动装配
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

}
