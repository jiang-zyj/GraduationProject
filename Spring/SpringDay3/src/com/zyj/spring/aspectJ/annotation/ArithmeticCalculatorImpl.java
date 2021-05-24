package com.zyj.spring.aspectJ.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName ArithmeticCalculatorImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 19:07
 * @Description: com.zyj.spring.aop.before.impl
 * @version: 1.0
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    // 代理类可以通过继承目标对象（该类）来代理目标对象自己定义的方法
//    public void a() {
//
//    }
    @Override
    public int add(int i, int j) {
        // 添加日志
        int result = i + j;
        // 添加日志
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
