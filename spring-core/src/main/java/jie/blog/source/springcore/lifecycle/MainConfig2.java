package jie.blog.source.springcore.lifecycle;

import jie.blog.source.springcore.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author: wyj
 * @date: 2019/8/30
 * @description:
 */
@Configuration
public class MainConfig2 {

    @Scope(value = "prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car01() {
        return new Car();
    }
}