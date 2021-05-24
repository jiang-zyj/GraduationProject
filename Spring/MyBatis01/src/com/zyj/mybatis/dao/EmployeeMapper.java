package com.zyj.mybatis.dao;

import com.zyj.mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @ClassName EmployeeMapper
 * @Auther: YaJun
 * @Date: 2021 - 04 - 19 - 10:57
 * @Description: com.zyj.mybatis.dao
 * @version: 1.0
 */
public interface EmployeeMapper {

    // 定义 CRUD 相关的方法

    // 根据 id 查询 Employee
    public Employee getEmployeeById(Integer id);

    // 添加一个新的 Employee
    public void addEmployee(Employee employee);

    // 修改一个 Employee
    public void updateEmployee(Employee employee);

    // 删除一个 Employee
    public boolean deleteEmployeeById(Integer id);

    //
    public Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmployeeByMap(Map<String,Object> map);
}
