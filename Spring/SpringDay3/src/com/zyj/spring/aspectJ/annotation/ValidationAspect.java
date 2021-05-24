package com.zyj.spring.aspectJ.annotation;

/**
 * @ClassName ValidationAspect
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 12:13
 * @Description: com.zyj.spring.aspectJ.annotation
 * @version: 1.0
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *  验证切面
 */
@Component
@Aspect
@Order(1)    // 设置切面的优先级 默认为 2147483647，值越小优先级越高
public class ValidationAspect {

//    @Before("execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))")
    @Before("LoggingAspect.declarePointCut()")    // 或者写成 com.zyj.spring.aspectJ.annotation.LoggingAspect.declarePointCut() 也是可以的
    public void beforeMethod(JoinPoint joinPoint) {
        Signature methodName = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidationAspect ==> The Method " + methodName + " args:" + Arrays.asList(args));

    }

}
