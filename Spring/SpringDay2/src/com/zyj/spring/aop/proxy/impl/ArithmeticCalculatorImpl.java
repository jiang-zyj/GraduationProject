package com.zyj.spring.aop.proxy.impl;

import com.zyj.spring.aop.proxy.ArithmeticCalculator;

/**
 * @ClassName ArithmeticCalculatorImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 19:07
 * @Description: com.zyj.spring.aop.before.impl
 * @version: 1.0
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
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