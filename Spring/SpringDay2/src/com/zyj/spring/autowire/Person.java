package com.zyj.spring.autowire;

/**
 * @ClassName Person
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 14:35
 * @Description: com.zyj.spring.autowire
 * @version: 1.0
 */
public class Person {

    private String name;

    private Car car;

    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", address=" + address +
                '}';
    }

    public Person() {
    }
}
