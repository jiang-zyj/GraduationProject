package com.zyj.spring.aspectJ.annotation;

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
@Component  // 标识为一个组件
@Aspect     // 标识为一个切面
@Order(2)
public class LoggingAspect {

    /**
     *  如何重用切入点表达式
     *
     *  声明切入点表达式
     *  也可以到其他切面中来使用该切入点表达式【使用 类名.方法名】
     */
    @Pointcut("execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))")
    public void declarePointCut() {}


    /**
     *  前置通知：在目标方法（连接点）执行之前执行
     */
    // 使用切入点表达式来确定在哪个方法（连接点）前执行，因为可能重载，所以还需确定返回值类型，参数类型
    @Before("declarePointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        // 通过连接点对象获取方法的参数
        Object[] args = joinPoint.getArgs();
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " begin with " + Arrays.asList(args));
    }


    /**
     *  后置通知：在目标方法执行之后执行，不管目标方法有没有抛出异常，都会执行。但是不能获取方法的结果
     *      * com.zyj.spring.aspectJ.annotation.*.*(..)))
     *      第一个 *：任意修饰符 任意返回值
     *      第二个 *：任意类
     *      第三个 *：任意方法
     *      ..：任意参数列表
     *
     *  连接点对象：JoinPoint
     */
    @After("execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))")
    public void afterMethod(JoinPoint joinPoint) {
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        // 通过连接点对象获取方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect ==> The Method " + methodName + " end with " + Arrays.asList(args));
    }

    /**
     *  返回通知：在目标方法正常执行结束后执行，可以获取到方法的返回值
     *
     *  获取方法的返回值：通过 returning 来指定一个名字，必须要与方法中的一个形参名一致
     */
    @AfterReturning(value = "execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))", returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        // 通过连接点对象获取方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " end with " + result);
    }

    /**
     *  异常通知：在目标方法抛出异常后执行
     *
     *  获取方法的异常：通过 throwing 来指定一个名字，必须要与方法中的一个形参名一致
     *
     *  可以通过形参中异常的类型来设置抛出指定异常才会执行异常通知
     */
    @AfterThrowing(value = "execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, ArithmeticException ex) {
        // 方法的名字
        Signature methodName = joinPoint.getSignature();
        System.out.println("LoggingAspect ==> The Method " + methodName + " occurs Exception:" + ex);
    }

    /**
     *  环绕通知：环绕着目标方法执行，可以理解是 前置 后置，返回，异常通知的结合体，更像是动态代理的整个过程
     */
    @Around("execution(* com.zyj.spring.aspectJ.annotation.*.*(..)))")
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
