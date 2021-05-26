package com.zyj.principle.singleResponsibility;

/**
 * @author 才二
 * @ClassName SingleResponsibility03
 * @Auther: YaJun
 * @Date: 2021 - 05 - 26 - 19:08
 * @Description: com.zyj.principle.singleResponsibility
 * @version: 1.0
 */
public class SingleResponsibility03 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runRoad("汽车");
        vehicle2.runWater("船");
        vehicle2.runAir("飞机");
    }

}

/**
 * 方案3的分析
 * 1. 这种修改方法没有对原来的类做大的修改，只是增加方法
 * 2. 这里虽然没有在类级别上遵守单一职责原则，但是在方法级别上遵守了了单一职责原则
 */

class Vehicle2 {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + "在公路跑...");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天空跑...");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水里跑...");
    }

}