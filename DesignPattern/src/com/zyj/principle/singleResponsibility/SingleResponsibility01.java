package com.zyj.principle.singleResponsibility;

/**
 * @author 才二
 * @ClassName SingleResponsibility01
 * @Auther: YaJun
 * @Date: 2021 - 05 - 26 - 15:54
 * @Description: com.zyj.principle.singleResponsibility
 * @version: 1.0
 */
public class SingleResponsibility01 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        vehicle.run("摩托");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

}

// 交通工具类
// 方式 1
// 1. 在方式 1 的 run 方法中，违反了单一职责原则
// 2. 解决方案，根据交通工具运行方法不同，分解为不同的类即可

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑...");
    }
}
