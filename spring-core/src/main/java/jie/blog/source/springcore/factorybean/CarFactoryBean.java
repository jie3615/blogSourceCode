package jie.blog.source.springcore.factorybean;

import jie.blog.source.springcore.bean.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author : wyj
 * @date: 2019/8/30
 * @description:
 */
public class CarFactoryBean implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}