package com.zyj.mybatis.test;

import com.zyj.mybatis.beans.Employee;
import com.zyj.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestMybatis
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 20:33
 * @Description: com.zyj.mybatis.test
 * @version: 1.0
 */
public class TestMybatis {

    /**
     * Mybatis HelloWorld 小结：
     *  两个重要的配置文件
     *      mybatis-config.xml: 全局配置文件，数据库的连接信息，引入 SQL 映射文件等...
     *      EmployeeMapper.xml: SQL 映射文件,配置增删改查 SQL 语句的映射。
     *  两个重要的对象
     *      SqlSessionFactory: SqlSession 的工厂对象,主要用于获取 SqlSession 对象
     *      SqlSession: Java程序与数据库的会话对象。可以理解为对 Connection 对象的封装
     */
    public static void main(String[] args) throws Exception {
//        testSqlSessionFactory();
//        testHelloWorldMapper();
//        testCRUD();
//        testParameter();
        testSelect();
    }

    private static void testSelect() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession(true);
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

//            List<Employee> employees = mapper.getEmployees();
//            System.out.println(employees);

//            Map<String,Object> map = mapper.getEmployeeByIdReturnMap(4);
//            System.out.println(map);

            Map<Integer, Employee> res = mapper.getEmployeesReturnMap();
            System.out.println(res);
        } finally {
            session.close();
        }
    }

    private static void testParameter() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();

        SqlSession session = ssf.openSession();

        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//            Employee employee = mapper.getEmployeeByIdAndLastName(9, "修改测试");
//            System.out.println(employee);
            Map<String,Object> map = new HashMap<>();
            map.put("id", 9);
            map.put("ln", "修改测试");
            Employee employeeByMap = mapper.getEmployeeByMap(map);
            System.out.println(employeeByMap);
        } finally {
            session.close();
        }
    }

    private static void testCRUD() throws IOException {
        SqlSessionFactory ssf = getSqlSessionFactory();

        SqlSession session = ssf.openSession();
        // 设置自动提交
//        SqlSession session = ssf.openSession(true);
        try {
            // 获取 Mapper 接口的代理实现类对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            // 查询
//            Employee employee = mapper.getEmployeeById(3);
//            System.out.println(employee);

            // 添加
            Employee employee = new Employee(null, "小刘", "2254@qq.com", 1);
            mapper.addEmployee(employee);
            System.out.println("返回的主键值："  + employee.getId());

            // 伪代码，JDBC测试 获取新插入的主键值
//            Connection conn = null;
//            PreparedStatement ps = conn.prepareStatement("sql",PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.executeUpdate();
//            ps.getGeneratedKeys();

            // 修改
//            Employee employee = new Employee(9, "修改测试", "xg@qq.com", 1);
//            mapper.updateEmployee(employee);

            // 删除
//            Integer integer = mapper.deleteEmployeeById(5); // 0 | 1
//            System.out.println(integer);
//            Integer res = mapper.deleteEmployeeById(10);
//            System.out.println(res);

//            boolean b = mapper.deleteEmployeeById(10); // true | false
//            System.out.println(b);
            // 提交
            session.commit();


        } finally {
            session.close();
        }

    }

    private static void testHelloWorldMapper() throws IOException {
        // 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            // mapper 接口: dao 接口
            /**
             * 两个绑定：
             *      1. Mapper 接口与 SQL 映射文件的绑定。
             *          映射文件的 namespace 的值必须指定为接口的全类名。
             *      2.Mapper 接口的方法 与 SQL映射文件中的具体的SQL语句的绑定
             *          SQL 语句的 id 值必须指定成 接口的方法名
             *
             * Mapper 接口开发的好处：
             *      1.有更明确的类型约束
             *      2.接口本身：接口本身就是抽象，抽出了规范。
             */
            // 获取 Mybatis 为 Mapper 接口生成的代理实现类对象
            EmployeeMapper dao = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(dao.getClass().getName());
            Employee employee = dao.getEmployeeById(4);

            System.out.println(employee);
        } finally {

        }
    }

    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static void testSqlSessionFactory() throws Exception {
        // 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        System.out.println(sqlSessionFactory);
 
        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        System.out.println(sqlSession);

        // 使用 Mybatis 执行 SQL 语句
        try (SqlSession session = sqlSessionFactory.openSession()) {
            /**
             * Params:
             *  statement – Unique identifier matching the statement to use.
             *              SQL 语句的唯一标识
             *  parameter – A parameter object to pass to the statement.
             *              执行 SQL 需要用到的参数
             */
            Employee employee = session.selectOne(
                    "ss.selectEmployee", 4);
            System.out.println(employee);
        }
    }

}
