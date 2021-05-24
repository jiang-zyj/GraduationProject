package com.zyj.ssm.handler;

import com.zyj.ssm.beans.Employee;
import com.zyj.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmployeeHandler
 * @Auther: YaJun
 * @Date: 2021 - 04 - 22 - 21:25
 * @Description: com.zyj.ssm.handler
 * @version: 1.0
 */
@Controller
public class EmployeeHandler {

    @Autowired(required = false)
    private EmployeeService employeeService;
    /**
     * 显示所有的员工信息
     */
    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String listAllEmployees(Map<String,Object> map) {
        List<Employee> employees = employeeService.getAllEmployees();
        map.put("employees", employees);
        return "list";
    }

}
