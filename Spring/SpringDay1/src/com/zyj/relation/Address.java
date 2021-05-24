package com.zyj.relation;

/**
 * @ClassName Address
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 20:22
 * @Description: com.zyj.relation
 * @version: 1.0
 */
public class Address {

    private String city;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
