package com.zyj.pojo;

/**
 * @ClassName User
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 13:23
 * @Description: com.zyj.pojo
 * @version: 1.0
 */
public class User {

    private int id; // 成员变量
    private String name; // 成员变量

    public int getId() {
        return id;
    }

    public void setId(int id) { // 属性
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
