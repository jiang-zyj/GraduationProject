package com.zyj.spring.aop.proxy;

/**
 * @ClassName ArithmeticCalculatorProxy
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 19:48
 * @Description: com.zyj.spring.aop.before
 * @version: 1.0
 */

import com.zyj.spring.aop.proxy.impl.ArithmeticCalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理：
 *      基于接口实现动态代理：JDK动态代理
 *          代理类与目标对象继承同一个接口，从而可以代理目标对象所实现的接口的所有方法
 *      基于继承实现动态代理：Cglib、Javassist动态代理
 *          代理类通过继承目标类，从而可以代理目标类中自己定义的方法，而不局限于接口定义的方法
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
public class ArithmeticCalculatorProxy {
    /**
     * 动态代理：(代理模式：给原对象封装起来，对外使用代理类，实际实现是通过原对象来实现对应的方法)
     *      1.获取目标对象    new 一个目标对象
     *      2.如何获取代理对象  通过所有动态代理的父类中的 Proxy.newInstance() 方法来获取代理对象
     *      3.代理要做什么    在 InvocationHandler 中的 invoke 方法中实现所需要做的事
     */
    // 目标对象 ArithmeticCalculatorImpl【这里使用接口声明该类，待会想办法把实例化的类弄出来就可以了】
    private ArithmeticCalculator target;

    public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    // 获取代理对象的方法
    public Object getProxy() {
        // 定义代理对象
        Object proxy;

        /**
         *  loader：ClassLoader 对象。类加载器对象，帮我们加载动态的代理类(加载目标对象或者说是类)
         *
         *  interfaces:接口们。提供目标对象的所有的接口。目的是让代理对象保证与目标对象都有相同的接口以及相同的方法。
         *
         *  h：InvocationHandler 类型的对象
         */
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
//        InvocationHandler h ;
        // 生成代理对象
        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            /**
             *  invoke：代理对象调用代理方法，会回来调用 invoke 方法。
             *  最终执行：代理类如何代理目标类执行到 invoke 方法
             *      经过反编译文件可以看到，其实在动态代理类中有一个构造方法，它将传进来的 InvocationHandler h 这个对象又传递给了父类 Proxy，
             *      在父类中又将该 h 传递给了父类 Proxy 中定义的 InvocationHandler h;在反编译后的代理类中可以看到对应的方法中
             *      实际的操作是 return super.h.invoke() 方法。所以会执行 InvocationHandler 中的 invoke 方法。所以最后会有
             *      对应的日志信息出现。
             *
             *  proxy：代理对象，在 invoke 方法中一般不会使用。
             *
             *  method：正在被调用的方法对象。
             *
             *  args：正在被调用的方法的参数。
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 将方法的调用转回到目标对象上。
                // 记录日志
                String methodName = method.getName();
                System.out.println("loggingProxy ==> The method:" + methodName + "begin with:" + Arrays.asList(args));
                Object result = method.invoke(target, args);// 目标对象执行目标方法；相当于执行 ArithmeticCalculatorImpl 中的 + - * / 方法
                // 记录日志
                System.out.println("LoggingProxy ==> The method:" + methodName + "end with:" + result);
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
