package com.zyj.spring.autowire;

/**
 * @ClassName Address
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 14:34
 * @Description: com.zyj.spring.autowire
 * @version: 1.0
 */
public class Address {

    private String province;

    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address() {
    }
}
