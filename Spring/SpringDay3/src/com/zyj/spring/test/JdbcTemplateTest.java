package com.zyj.spring.test;

import com.zyj.spring.jdbc.User;
import com.zyj.spring.jdbc.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JdbcTemplateTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 15:55
 * @Description: com.zyj.spring.test
 * @version: 1.0
 */
public class JdbcTemplateTest {

    static private JdbcTemplate jdbcTemplate;

    static private NamedParameterJdbcTemplate npjt;

    static private UserDao userDao;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        npjt = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        userDao = context.getBean("userDao", UserDao.class);
//        testUpdate();
//        System.out.println("-----------------");
//        testBatchUpdate();
//        testQueryForObjectReturnObject();
//        testQueryForObjectReturnValue();
//        testQuery();
//        testNpjt();
//        testNpjtObject();
        testUserDao();
    }




    /**
     * update()：增删改操作
     */

    public static void testUpdate() {
        String sql = "insert into user values (null, ?,?)";
        jdbcTemplate.update(sql, "admin10", "123");
        int i = jdbcTemplate.update(sql, new Object[]{"admin11", "123"});
        if (i > 0) {
            System.out.println(1);
        }
    }

    /**
     * batchUpdate()：批量增删改
     */
    private static void testBatchUpdate() {
        String sql = "insert into user values (null, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"admin12", "123"});
        batchArgs.add(new Object[]{"admin13", "123"});
        batchArgs.add(new Object[]{"admin14", "123"});
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        for (int anInt : ints) {
            if (anInt > 0) {
                System.out.print(1 + ",");
            }
        }
    }

    /**
     * queryForObject()：
     * 1、查询单行数据，返回一个对象
     * 2、查询单行，返回一个值
     */
    // 1、查询单行数据，返回一个对象
    private static void testQueryForObjectReturnObject() {
        String sql = "select * from user where id = ?";
        // rowMapper：行映射。将结果集的一条数据映射成一个具体的 java 对象
        // 快捷键 ctrl + alt + b 查看接口的实现类
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 28);
        System.out.println(user);
    }

    // 2、查询单行，返回一个值
    private static void testQueryForObjectReturnValue() {
        String sql = "select count(1) from user ";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(result);
    }


    /**
     * query()：查询多条数据，返回多个对象的集合。
     */
    private static void testQuery() {
        String sql = "select * from user where id > ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper, 28);
        System.out.println(users);
    }

    /**
     * 测试具名模板类
     */
    private static void testNpjt() {
        String sql = "insert into user values(null,:un,:pw)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("un", "admin10086");
        paramMap.put("pw", "123");

        npjt.update(sql, paramMap);
    }

    private static void testNpjtObject() {
        // 模拟 Service 层，直接传递给 Dao 层一个具体的对象
        User user = new User(1001, "曾亚军", "123");

        // 在 Dao 层的插入方法中：
        String sql = "insert into user values(null,:username,:password)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        npjt.update(sql, paramSource);

    }

    /**
     * 测试 UserDao
     */
    private static void testUserDao() {
        User user = new User(1002, "曾亚军2", "123");
        userDao.insertUser(user);
    }
}
