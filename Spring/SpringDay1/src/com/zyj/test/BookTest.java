package com.zyj.test;

import com.zyj.DI.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BookTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:08
 * @Description: com.zyj.test
 * @version: 1.0
 */
public class BookTest {

    public static void main(String[] args) {
        // 测试字面量
        TestZML();
    }

    private static void TestZML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

}
