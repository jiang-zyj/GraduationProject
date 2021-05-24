package com.zyj.spring.aspectJ.xml;

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

public class ValidationAspect {
    public void beforeMethod(JoinPoint joinPoint) {
        Signature methodName = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidationAspect ==> The Method " + methodName + " args:" + Arrays.asList(args));

    }

}
