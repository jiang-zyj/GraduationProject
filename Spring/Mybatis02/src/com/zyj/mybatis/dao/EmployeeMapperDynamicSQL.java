package com.zyj.mybatis.dao;

import com.zyj.mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 才二
 * @ClassName EmployeeMapperDynamicSQL
 * @Auther: YaJun
 * @Date: 2021 - 04 - 21 - 11:34
 * @Description: com.zyj.mybatis.dao
 * @version: 1.0
 */
public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmployeesByConditionIfWhere(Employee condition);

    public List<Employee> getEmployeesByConditionIfTrim(Employee condition);

    public void updateEmpByConditionSet(Employee condition);

    public List<Employee> getEmployeesByConditionChoose(Employee condition);

    public List<Employee> getEmployeesByIds(@Param("ids") List<Integer> ids);

    // 批量操作：修改、删除、添加
    public void addEmployees(@Param("employees") List<Employee> employees);
}
