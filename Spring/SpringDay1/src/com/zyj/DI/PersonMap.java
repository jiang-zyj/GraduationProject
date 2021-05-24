package com.zyj.DI;

import java.util.Map;

/**
 * @ClassName PersonMap
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 17:49
 * @Description: com.zyj.DI
 * @version: 1.0
 */
public class PersonMap {

    private String name;
    private Map<String,Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public PersonMap() {
    }

    @Override
    public String toString() {
        return "PersonMap{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
