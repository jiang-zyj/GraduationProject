package com.zyj.mybatis.test;

import com.zyj.mybatis.beans.Department;
import com.zyj.mybatis.beans.Employee;
import com.zyj.mybatis.dao.DepartmentMapperResultMap;
import com.zyj.mybatis.dao.EmployeeMapperResultMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 才二
 * @ClassName TestMybatisResultMap
 * @Auther: YaJun
 * @Date: 2021 - 04 - 20 - 21:01
 * @Description: com.zyj.mybatis.test
 * @version: 1.0
 */
public class TestMybatisResultMap {

    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) throws IOException {
//        testResultMap();
//        testResultMapCasccade();
//        testResultMapAssociation();
//        testResultMapCollection();
        testResultMapCollectionStep();
    }

    private static void testResultMapCollectionStep() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            DepartmentMapperResultMap mapper = session.getMapper(DepartmentMapperResultMap.class);

            Department dept = mapper.getDeptAndEmployeesStep(1);
            System.out.println(dept.getDeptName());
            System.out.println("----------------------");

            System.out.println(dept.getEmployees());
        } finally {
            session.close();
        }
    }

    private static void testResultMapCollection() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            DepartmentMapperResultMap mapper = session.getMapper(DepartmentMapperResultMap.class);

            Department dept = mapper.getDeptAndEmp(1);
            System.out.println(dept);
            System.out.println("----------------------");

            System.out.println(dept.getEmployees());
        } finally {
            session.close();
        }
    }

    private static void testResultMapAssociation() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperResultMap mapper = session.getMapper(EmployeeMapperResultMap.class);

            Employee employee = mapper.getEmpAndDeptStep(4);
            System.out.println(employee.getLast_Name());
            System.out.println("----------------------");

            System.out.println(employee.getDept());
        } finally {
            session.close();
        }
    }

    private static void testResultMapCasccade() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperResultMap mapper = session.getMapper(EmployeeMapperResultMap.class);

            Employee employee = mapper.getEmpAndDept(4);
            System.out.println(employee);
            System.out.println(employee.getDept());
        } finally {
            session.close();
        }
    }

    private static void testResultMap() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);

        try {
            EmployeeMapperResultMap mapper = session.getMapper(EmployeeMapperResultMap.class);

            Employee employee = mapper.getEmployeeById(4);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

}
