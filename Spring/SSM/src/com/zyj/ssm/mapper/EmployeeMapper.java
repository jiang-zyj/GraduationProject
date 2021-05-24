package com.zyj.ssm.mapper;

import com.zyj.ssm.beans.Employee;

import java.util.List;

/**
 * @ClassName EmployeeMapper
 * @Auther: YaJun
 * @Date: 2021 - 04 - 22 - 20:56
 * @Description: com.zyj.ssm.mapper
 * @version: 1.0
 */
public interface EmployeeMapper {

    public List<Employee> getAllEmployees();

}
