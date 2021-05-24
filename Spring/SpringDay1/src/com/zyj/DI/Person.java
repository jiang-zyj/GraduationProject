package com.zyj.DI;

/**
 * @ClassName Person
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:16
 * @Description: com.zyj.DI
 * @version: 1.0
 */
public class Person {

    private Integer id;
    private String name;
    private Car car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
