package com.zyj.DI;

/**
 * @ClassName Car
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 16:11
 * @Description: com.zyj.DI
 * @version: 1.0
 */
public class Car {

    private String brand;   // 品牌
    private String crop;    // 厂牌
    private Double price;   // 价格
    private Integer speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Car() {

    }
    public Car(String brand, String crop, Integer speed) {
        this.brand = brand;
        this.crop = crop;
        this.speed = speed;
    }
    public Car(String brand, String crop, Double price) {
        this.brand = brand;
        this.crop = crop;
        this.price = price;
    }



    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", crop='" + crop + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
