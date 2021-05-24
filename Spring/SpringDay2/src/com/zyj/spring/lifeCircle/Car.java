package com.zyj.spring.lifeCircle;

/**
 * @ClassName Car
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 11:50
 * @Description: com.zyj.spring.lifeCircle
 * @version: 1.0
 */
public class Car {

    private String brand;
    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("===> 2. 调用 set 方法给属性赋值");
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *  初始化方法
     *  需要通过 init-method 来指定初始化方法
     */
    public void init() {
        System.out.println("===> 3. 调用初始化方法");
    }

    /**
     *  销毁方法：IOC 容器关闭，bean 对象被销毁 通过 destroy-method 来指定销毁方法
     */
    public void destroy() {
        System.out.println("===> 5.调用销毁方法");
    }

    public Car() {
        System.out.println("====> 1.调用构造器创建 bean 对象");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
