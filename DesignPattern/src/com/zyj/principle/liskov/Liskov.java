package com.zyj.principle.liskov;

/**
 * @author 才二
 * @ClassName Liskov
 * @Auther: YaJun
 * @Date: 2021 - 05 - 26 - 20:34
 * @Description: com.zyj.principle.liskov
 * @version: 1.0
 */
public class Liskov {

    public static void main(String[] args) {

        A a = new A();
        System.out.println("11 - 3 = " + a.func1(11, 3));

        System.out.println("-------------------------");

        B b = new B();
        System.out.println("11 - 3 = " + b.func1(11, 3));
//        System.out.println("");
    }

}

class A {

    /**
     * 返回两个数的差
     * @param num1
     * @param num2
     * @return
     */
    public int func1(int num1, int num2) {
        return num1 - num2;
    }

}

/**
 * B 类继承了 A 类
 * 增加了一个新的功能，完成两个数相加，然后跟 9 求和
 */
class B extends A {

    /**
     * 这里重写了 A 类的方法，可能不是故意重写的
     * @return
     */
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}
