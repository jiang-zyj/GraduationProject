package com.zyj.test;

import com.zyj.DI.Person;
import com.zyj.DI.PersonList;
import com.zyj.DI.PersonMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName PersonTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:19
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class PersonTest {

    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static void main(String[] args) {
        // 外部引用 bean
        refTest();
        // 内部 bean
        innerTest();
        // null 值
        nullTest();
        // List
        ListTest();
        // Map
        MapTest();
        // 集合bean
        ListTest2();
    }

    private static void ListTest2() {
        PersonList personList2 = context.getBean("personList2", PersonList.class);
        System.out.println(personList2);
    }

    private static void MapTest() {
        PersonMap personMap = context.getBean("personMap", PersonMap.class);
        System.out.println(personMap);
    }

    private static void ListTest() {
        PersonList personList = context.getBean("personList", PersonList.class);
        System.out.println(personList);
    }

    private static void nullTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person3 = context.getBean("person2", Person.class);
        System.out.println(person3);
    }

    private static void innerTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);
    }

    private static void refTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }



}
