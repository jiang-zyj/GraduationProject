package com.zyj.principle.inversion.improve;

/**
 * @author 才二
 * @ClassName DependencyInversion
 * @Auther: YaJun
 * @Date: 2021 - 05 - 26 - 19:59
 * @Description: com.zyj.principle.inversion
 * @version: 1.0
 */
public class DependencyInversion {

    public static void main(String[] args) {

        Person person = new Person();
        // 通过接口来依赖Email类
        person.receive(new Email());

        person.receive(new wx());
    }

}

// 定义一个接口

interface IReceiver {
    /**
     * 声明接收信息的方法
     * @return
     */
    public String getInfo();

}

class Email implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮件信息：Hello World";
    }
}

class wx implements IReceiver {
    @Override
    public String getInfo() {
        return "wx Hello";
    }
}

/**
 * 方式 2：
 */

class Person {

    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}