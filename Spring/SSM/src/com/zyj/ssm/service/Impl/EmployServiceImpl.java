package com.zyj.ssm.service.Impl;

import com.zyj.ssm.beans.Employee;
import com.zyj.ssm.mapper.EmployeeMapper;
import com.zyj.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 22 - 21:27
 * @Description: com.zyj.ssm.service.Impl
 * @version: 1.0
 */
@Service
public class EmployServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }
}
