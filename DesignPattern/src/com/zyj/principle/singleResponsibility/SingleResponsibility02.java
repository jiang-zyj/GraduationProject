package com.zyj.principle.singleResponsibility;

/**
 * @author 才二
 * @ClassName SingleResponsibility02
 * @Auther: YaJun
 * @Date: 2021 - 05 - 26 - 15:59
 * @Description: com.zyj.principle.singleResponsibility
 * @version: 1.0
 */
public class SingleResponsibility02 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        roadVehicle.run("摩托");
        waterVehicle.run("船");
        airVehicle.run("飞机");
    }

}

// 方案2的分析
// 1. 遵守了单一职责原则
// 2. 但是这样做的开销很大，改动也很大，且同时修改客户端
// 3. 改进：直接修改 Vehicle 类，改动的代码比较少

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路跑...");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空跑...");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水里跑...");
    }
}


