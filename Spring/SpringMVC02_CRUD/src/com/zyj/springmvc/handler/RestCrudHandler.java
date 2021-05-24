/*
package com.zyj.springmvc.handler;

import com.zyj.springmvc.bean.Department;
import com.zyj.springmvc.bean.Employee;
import com.zyj.springmvc.Dao.DepartmentDao;
import com.zyj.springmvc.Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @ClassName RestCrudHandler
 * @Auther: YaJun
 * @Date: 2021 - 04 - 14 - 12:36
 * @Description: com.zyj.springmvc.handler
 * @version: 1.0
 *//*

@Controller
public class RestCrudHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    */
/**
     * 修改功能：具体的修改操作
     *//*

    @RequestMapping(value = "emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    */
/**
     * 修改功能：去往修改页面
     *//*

    @RequestMapping(value = "emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id, Map<String,Object> map) {
        // 查询要修改的员工信息
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);

        // 页面中显示部门下拉列表的数据
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        // 页面中显示单选框的数据
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);
        // 去往修改页面
        return "input";
    }


    */
/**
     * 删除功能
     *//*

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        // 删除员工
        employeeDao.delete(id);
        // 重定向到列表
        return "redirect:/emps";
    }


    */
/**
     * 添加功能：具体的添加操作
     * @param employee
     * @return
     *//*

    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        // 添加员工
        employeeDao.save(employee);
        // 回到列表页面
        // 重定向到列表页面：重定向到显示所有员工信息列表的请求
        return "redirect:/emps";
    }

    */
/**
     * 添加功能：去往添加页面
     *
     * 添加页面需要部门数据
     *//*

    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String toAddPage(Map<String,Object> map) {
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);

        // 2.构造页面中生成单选框的数据
        Map<String,String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);

        // 3.设置页面回显的数据
        map.put("employee", new Employee());
        return "input";
    }


    */
/**
     * 显示所有的员工信息列表
     * @param map
     * @return
     *//*

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String listAllEmps(Map<String,Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

}
*/
