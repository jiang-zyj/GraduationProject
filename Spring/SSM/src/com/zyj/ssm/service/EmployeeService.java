package com.zyj.ssm.service;

import com.zyj.ssm.beans.Employee;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Auther: YaJun
 * @Date: 2021 - 04 - 22 - 21:26
 * @Description: com.zyj.ssm.service
 * @version: 1.0
 */
public interface EmployeeService {

    public List<Employee> getAllEmployees();

}
