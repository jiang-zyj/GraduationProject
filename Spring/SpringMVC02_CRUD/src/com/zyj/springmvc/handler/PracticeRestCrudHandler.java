package com.zyj.springmvc.handler;

import com.zyj.springmvc.bean.Department;
import com.zyj.springmvc.bean.Employee;
import com.zyj.springmvc.dao.DepartmentDao;
import com.zyj.springmvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
* @ClassName PracticeRestCrudHandler
* @Auther:  YaJun
* @Date: 2021 - 04 - 14 - 22:38
* @Description: com.zyj.springmvc.handler
* @version: 1.0
*/
@Controller
public class PracticeRestCrudHandler {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 修改操作
     */
    @RequestMapping(value = "employee", method = RequestMethod.PUT)
    public String editEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    /**
     * 去往修改页面
     */
    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
    public String toEditEmpPage(@PathVariable("id") Integer id, Map<String,Object> map) {
        // 存放性别
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);
        // 存放部门编号
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);
        return "input";
    }

    /**
     * 删除操作
     */
    @RequestMapping(value = "employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employees";
    }

    /**
     * 具体的添加操作
     */
    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    /**
     * 去往添加页面
     * @return
     */
    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String toAddEmpPage(Map<String,Object> map) {
        // 存放部门编号
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        // 存放性别
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);
        // 由于是添加操作，不需要一个有数据的 Employee 对象，则可以存放空的 Employee 对象
        map.put("employee", new Employee());
        return "input";
    }
    /**
     * 查询
     * @param map
     * @return
     */
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String empsList(Map<String,Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

}
