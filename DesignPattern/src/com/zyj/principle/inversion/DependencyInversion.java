package com.zyj.principle.inversion;

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
        person.receive(new Email());

    }

}



class Email {
    public String getInfo() {
        return "电子邮件信息：Hello World";
    }
}

/**
 * 完成Person接收消息的功能
 * 方式 1 分析：
 * 1. 简单，比较容易想到
 * 2. 如果我们获取的对象是 微信、短信等，则需要新增类，同时 Person 也要增加响应的接收方法
 * 3. 解决思路：引入一个抽象的接口 IReceiver，表示接收者，这样 Person 类与接口 IReceiver 发生依赖
 *      因为 Email，微信 等等都是属于接收的范围，它们各自实现 IReceiver 接口就 ok，这样就符合依赖倒转原则。
 */

class Person {

    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}