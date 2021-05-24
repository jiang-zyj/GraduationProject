package com.zyj.spring.lifeCircle;

/**
 * @ClassName MyBeanPostProcessor
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 12:01
 * @Description: com.zyj.spring.lifeCircle
 * @version: 1.0
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *  bean 的后置处理器：对 IOC 容器中所有的 bean 都起作用
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在 bean 的生命周期的初始化方法之前执行
     * @param bean  正在被创建的 bean 对象
     * @param beanName  bean 对象的 id 值
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }


    /**
     * 在 bean 的生命周期的初始化方法之后执行
     * @param bean  正在被创建的 bean 对象
     * @param beanName  bean 对象的 id 值
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }
}
