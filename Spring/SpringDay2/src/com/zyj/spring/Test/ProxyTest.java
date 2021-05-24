package com.zyj.spring.Test;

import com.zyj.spring.aop.proxy.ArithmeticCalculator;
import com.zyj.spring.aop.proxy.ArithmeticCalculatorProxy;
import com.zyj.spring.aop.proxy.ArithmeticCalculatorProxy2;
import com.zyj.spring.aop.proxy.impl.ArithmeticCalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @ClassName ProxyTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 20:32
 * @Description: com.zyj.spring.Test
 * @version: 1.0
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {

        // 将动态生成的代理类保存下来
        Properties properties = System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "ture");

        // 目标对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        // 获取代理对象
        Object obj = new ArithmeticCalculatorProxy(target).getProxy();

        // 转回具体的类型  【只能转成接口类型的，因为代理对象与目标对象是都实现了相同的接口，但是它们之间不能相互转换】
        ArithmeticCalculator proxy = (ArithmeticCalculator) obj;

        System.out.println(proxy.getClass().getName());

        //
        int result = proxy.add(1, 1);
        System.out.println("result:" + result);
        System.out.println("-----------------------------------");

        /**
         *  问题：
         *      1.代理对象能否转换成目标对象的类型？
         *          不能
         *      2.代理对象调用代理方法，为什么会执行 InvocationHandler 中的 invoke 方法
         *          因为经过反编译后的动态代理类($proxy0)中它在 add 方法中做的是 return super.h.invoke;
         *          就等于使用自己创建的 h(InvocationHandler对象) 来执行了 invoke 方法。
         *      最终执行：代理类如何代理目标类执行到 invoke 方法
         *              经过反编译文件可以看到，其实在动态代理类中有一个构造方法，它将传进来的 InvocationHandler h 这个对象又传递给了父类 Proxy，
         *              在父类中又将该 h 传递给了父类 Proxy 中定义的 InvocationHandler h;在反编译后的代理类中可以看到对应的方法中
         *              实际的操作是 return super.h.invoke() 方法。所以会执行 InvocationHandler 中的 invoke 方法。所以最后会有
         *              对应的日志信息出现。
         */
        test();
        System.out.println("-------------------------------------");
        proxy2();
    }

    private static void proxy2() throws Exception {
        // 目标对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        // 获取代理对象
        Object obj = new ArithmeticCalculatorProxy2(target).getProxy();

        // 转回具体的类型  【只能转成接口类型的，因为代理对象与目标对象是都实现了相同的接口，但是它们之间不能相互转换】
        ArithmeticCalculator proxy = (ArithmeticCalculator) obj;

        System.out.println(proxy.getClass().getName());

        //
        int result = proxy.add(1, 1);
        System.out.println("result:" + result);
    }

    private static void test() {
        // 获取代理对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        Object proxy = new ArithmeticCalculatorProxy(target).getProxy();
        // 将代理对象转换为接口类型的，因为代理对象和目标对象都实现了共同的接口，这是它们之间的共性
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) proxy;
        int add = arithmeticCalculator.add(1, 2);
        System.out.println(add);
    }


    /**
     *  模拟底层生成的动态代理类
     *
     */
    class $Proxy0 extends Proxy implements ArithmeticCalculator{

        /**
         * Constructs a new {@code Proxy} instance from a subclass
         * (typically, a dynamic proxy class) with the specified value
         * for its invocation handler.
         *
         * @param h the invocation handler for this proxy instance
         * @throws NullPointerException if the given invocation handler, {@code h},
         *                              is {@code null}.
         */
        protected $Proxy0(InvocationHandler h) {
            super(h);
        }

        @Override
        public int add(int i, int j) {
//            return super.h.invoke(this, "方法名", "方法参数");
            return 0;
        }

        @Override
        public int sub(int i, int j) {
            return 0;
        }

        @Override
        public int mul(int i, int j) {
            return 0;
        }

        @Override
        public int div(int i, int j) {
            return 0;
        }
    }
}
