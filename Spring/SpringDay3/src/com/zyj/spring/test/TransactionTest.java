package com.zyj.spring.test;

import com.zyj.spring.tx.annotation.Dao.BookShopDao;
import com.zyj.spring.tx.annotation.Service.BookShopService;
import com.zyj.spring.tx.annotation.Service.Cashier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TransactionTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 23:09
 * @Description: com.zyj.spring.test
 * @version: 1.0
 */
public class TransactionTest {


    static private BookShopDao bookShopDao;
    static BookShopService bookShopService;
    static private Cashier cashier;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        bookShopDao = context.getBean("bookShopDaoImpl", BookShopDao.class);
        bookShopService = context.getBean("bookShopServiceImpl", BookShopService.class);
        cashier = context.getBean("cashierImpl", Cashier.class);
        System.out.println(bookShopService.getClass().getName());
        // 测试买一本书
        testTx();
        // 测试买多本书
//        testCheckOut();
    }

    private static void testCheckOut() {
        List<String> isbns = new ArrayList<>();
        isbns.add("1001");
        isbns.add("1002");
        cashier.checkOut("Tom", isbns);
    }

    private static void testTx() {

        // 模拟买书
        bookShopService.buyBook("Tom", "1001");

    }

}
