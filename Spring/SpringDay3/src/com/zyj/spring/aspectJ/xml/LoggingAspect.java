package com.zyj.spring.aspectJ.xml;

/**
 * @ClassName LoggingAspect
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 11:15
 * @Description: com.zyj.spring.aspectJ.annotation
 * @version: 1.0
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *  日志切面
 */
public class LoggingAspect {

    public void declarePointCut() {}


    public void beforeMethod(JoinPoint joinPoint) {
        // 通过连接点对象获取方法的参数
        Object[] args = joinPoint.getArgs();
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " begin with " + Arrays.asList(args));
    }


    public void afterMethod(JoinPoint joinPoint) {
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        // 通过连接点对象获取方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect ==> The Method " + methodName + " end with " + Arrays.asList(args));
    }

    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " end with " + result);
    }

    public void afterThrowingMethod(JoinPoint joinPoint, ArithmeticException ex) {
        // 方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " occurs Exception:" + ex);
    }

    public Object aroundMethod(ProceedingJoinPoint joinPoint) {

        try {
            // 执行目标方法
            // 前置
            Object result = joinPoint.proceed();
            // 返回
            return result;
        } catch (Throwable throwable) {
            // 异常
            throwable.printStackTrace();
        } finally {
            // 后置
        }
        return null;
    }
}
