package com.zyj.mybatis.dao;

import com.zyj.mybatis.beans.Department;

/**
 * @ClassName DepartmentMapperResultMap
 * @Auther: YaJun
 * @Date: 2021 - 04 - 20 - 21:42
 * @Description: com.zyj.mybatis.dao
 * @version: 1.0
 */
public interface DepartmentMapperResultMap {

    public Department getDeptById(Integer id);

    public Department getDeptAndEmp(Integer id);

    public Department getDeptAndEmployeesStep(Integer id);

}
