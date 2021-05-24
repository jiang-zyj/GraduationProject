package com.zyj.spring.autowire;

/**
 * @ClassName Car
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 14:33
 * @Description: com.zyj.spring.autowire
 * @version: 1.0
 */
public class Car {

    private String brand;

    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public Car() {
    }
}
