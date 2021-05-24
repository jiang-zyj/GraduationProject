package com.zyj.spring.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ClassName DataSourceTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 12:22
 * @Description: com.zyj.spring.Test
 * @version: 1.0
 */
public class DataSourceTest {

    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
            DataSource datasource = context.getBean("datasource", DataSource.class);
            System.out.println(datasource);
            System.out.println(datasource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
