package com.zyj.mybatis.test;

import com.zyj.mybatis.beans.Employee;
import com.zyj.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMybatisDynamicSQL
 * @Auther: YaJun
 * @Date: 2021 - 04 - 21 - 11:46
 * @Description: com.zyj.mybatis.test
 * @version: 1.0
 */
public class TestMybatisDynamicSQL {

    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) throws IOException {
//        testIf();
//        testTrim();
//        testSet();
//        testChoose();
//        testForeach();
        testBatch();
    }

    private static void testBatch() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);

            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(null,"AA","aa@zyj.com",0));
            employees.add(new Employee(null,"BB","bb@zyj.com",1));
            employees.add(new Employee(null,"CC","cc@zyj.com",0));
            mapper.addEmployees(employees);
        } finally {
            session.close();
        }
    }

    private static void testForeach() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);

            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            ids.add(4);
            List<Employee> employees = mapper.getEmployeesByIds(ids);
            System.out.println(employees);
        } finally {
            session.close();
        }
    }

    private static void testChoose() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
            Employee condition = new Employee();
//            condition.setId(4);
//            condition.setLast_Name("小慧");
//            condition.setEmail("xxh@zyj.com");
//            condition.setGender(0);
            List<Employee> employees = mapper.getEmployeesByConditionChoose(condition);
            System.out.println(employees);
        } finally {
            session.close();
        }
    }

    private static void testSet() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
            Employee condition = new Employee();
            condition.setId(4);
            condition.setLast_Name("小慧");
            condition.setEmail("xxh@zyj.com");
//            condition.setGender(0);
            mapper.updateEmpByConditionSet(condition);
        } finally {
            session.close();
        }
    }

    private static void testTrim() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
            Employee condition = new Employee();
            condition.setId(4);
            condition.setLast_Name("小慧");
            condition.setEmail("xxh@zyj.com");
//            condition.setGender(0);
            List<Employee> employees = mapper.getEmployeesByConditionIfTrim(condition);
            System.out.println(employees);
        } finally {
            session.close();
        }
    }

    private static void testIf() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
            Employee condition = new Employee();
//            condition.setId(4);
//            condition.setLast_Name("小慧");
            condition.setEmail("xxh@zyj.com");
//            condition.setGender(0);
            List<Employee> employees = mapper.getEmployeesByConditionIfWhere(condition);
            System.out.println(employees);
        } finally {
            session.close();
        }
    }

}
