package com.zyj.DI;

import java.util.List;

/**
 * @ClassName PersonList
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:38
 * @Description: com.zyj.DI
 * @version: 1.0
 */
public class PersonList {

    private String name;
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public PersonList() {
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
