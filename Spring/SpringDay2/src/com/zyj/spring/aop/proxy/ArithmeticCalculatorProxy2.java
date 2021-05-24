package com.zyj.spring.aop.proxy;

/**
 * @ClassName ArithmeticCalculatorProxy
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 19:48
 * @Description: com.zyj.spring.aop.before
 * @version: 1.0
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 生成代理对象
 *
 * JDK的动态代理：
 *      1. Proxy：是所有动态代理类的父类，专门用来生成代理类或代理对象。
 *              getProxyClass(ClassLoader loader, Class<?>... interfaces)
 *              用于生成代理类的 Class 对象。
 *              newProxyInstance()
 *              用于生成代理对象。
 *
 *      2. InvocationHandler：完成动态代理的整个过程。
 *              invoke()
 */
public class ArithmeticCalculatorProxy2 {
    /**
     * 动态代理：(代理模式：给原对象封装起来，对外使用代理类，实际实现是通过原对象来实现对应的方法)
     *      1.获取目标对象    new 一个目标对象
     *      2.如何获取代理对象  通过所有动态代理的父类中的 Proxy.newInstance() 方法来获取代理对象
     *      3.代理要做什么    在 InvocationHandler 中的 invoke 方法中实现所需要做的事
     */
    // 目标对象 ArithmeticCalculatorImpl【这里使用接口声明该类，待会想办法把实例化的类弄出来就可以了】
    private ArithmeticCalculator target;

    public ArithmeticCalculatorProxy2(ArithmeticCalculator target) {
        this.target = target;
    }

    // 获取代理对象的方法
    public Object getProxy() throws Exception {
        // 定义代理对象
        Object proxy;

        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        Class<?> proxyClass = Proxy.getProxyClass(loader,interfaces);

        // Class 创建对象？  newInstance()
        Constructor<?> con = proxyClass.getDeclaredConstructor(InvocationHandler.class);

        proxy = con.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 将方法的调用转回到目标对象上。
                // 记录日志
                String methodName = method.getName();
                System.out.println("loggingProxy2 ==> The method:" + methodName + "begin with:" + Arrays.asList(args));
                Object result = method.invoke(target, args);// 目标对象执行目标方法；相当于执行 ArithmeticCalculatorImpl 中的 + - * / 方法
                // 记录日志
                System.out.println("LoggingProxy2 ==> The method:" + methodName + "end with:" + result);
                return result;
            }
        });

        return proxy;
    }
    /*class MyInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }*/
}
