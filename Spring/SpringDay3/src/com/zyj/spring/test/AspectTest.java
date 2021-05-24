package com.zyj.spring.test;

import com.zyj.spring.aspectJ.annotation.ArithmeticCalculator;
import com.zyj.spring.aspectJ.annotation.ArithmeticCalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AspectTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 11:25
 * @Description: com.zyj.spring.aspectJ.annotation.test
 * @version: 1.0
 */
public class AspectTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aspectJ_annotation.xml");
        // 问题：为什么是用 ArithmeticCalculator.class 而不是 ArithmeticCalculatorImpl.class
        // ac 为代理对象，因为它俩都是实现了同一个接口，是兄弟关系，所以使用 接口.class，不能使用 实现类.class
        // 相对应的返回也不能是 实现类.class
        ArithmeticCalculator ac = context.getBean("arithmeticCalculatorImpl", ArithmeticCalculator.class);
        System.out.println(ac.getClass().getName());
        int ans = ac.add(1, 1);
        System.out.println(ans);
        System.out.println("-------------------");
        // 演示程序抛出异常后依旧执行后置通知
//        ans = ac.div(6, 0);
//        System.out.println(ans);
        System.out.println("-------------------");

    }

}
