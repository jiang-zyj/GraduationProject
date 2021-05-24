package com.zyj.mybatis.dao;

import com.zyj.mybatis.beans.Employee;

import java.util.List;

/**
 * @ClassName EmployeeMapperResultMap
 * @Auther: YaJun
 * @Date: 2021 - 04 - 20 - 20:46
 * @Description: com.zyj.mybatis.dao
 * @version: 1.0
 */
public interface EmployeeMapperResultMap {

    public Employee getEmployeeById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpAndDeptStep(Integer id);

    public List<Employee> getEmployeesByDid(Integer id);
}
