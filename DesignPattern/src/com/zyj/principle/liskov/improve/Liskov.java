package com.zyj.principle.liskov.improve;

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
        // 因为 B 类不再继承 A 类，因此调用者不会再使用 func1 来求减法了
        // 调用完成的功能就会很明确
        System.out.println("11 + 3 = " + b.func1(11, 3));

        // 使用组合的方式依然可以使用到 A 类的相关方法
        System.out.println("11 - 3 = " + b.func3(11, 3));
    }

}

/**
 * 创建一个更加基础的基类
 */
class Base {

}

class A extends Base{

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
class B extends Base {

    /**
     * 如果 B 需要使用 A 类中的方法，可以使用依赖、聚合、组合等方式来使用，这里使用组合的方式
     */
    private A a = new A();

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

    /**
     * 这里仍然使用 A 类的方法
     */
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}
