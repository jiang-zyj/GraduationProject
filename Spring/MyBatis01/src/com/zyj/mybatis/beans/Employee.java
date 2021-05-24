package com.zyj.mybatis.beans;

/**
 * @ClassName Employee
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 20:23
 * @Description: com.zyj.mybatis.beans
 * @version: 1.0
 */
public class Employee {

    private Integer id;

    private String last_Name;

    private String email;

    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Employee() {
    }

    public Employee(Integer id, String last_Name, String email, Integer gender) {
        this.id = id;
        this.last_Name = last_Name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_Name='" + last_Name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
