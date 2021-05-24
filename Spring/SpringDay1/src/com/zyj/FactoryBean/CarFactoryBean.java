package com.zyj.FactoryBean;

import com.zyj.DI.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName CarFactoryBean
 * @Auther: YaJun
 * @Date: 2021 - 03 - 16 - 20:03
 * @Description: com.zyj.FactoryBean
 * @version: 1.0
 */
public class CarFactoryBean implements FactoryBean<Car> {

    /**
     * 工厂 bean 具体创建的 bean 对象是由 getObject 方法来返回的
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car("五菱宏光", "五菱", 50000);
    }

    /**
     * 返回具体的 bean 对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * bean 可以是单例的 也可以是原型的（非单例）: 后面将 bean 的作用域的时候再研究
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }


}
