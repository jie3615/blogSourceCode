package jie.blog.source.springcore.config;

import jie.blog.source.springcore.bean.Person;
import jie.blog.source.springcore.factorybean.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Auther: wyj
 * @Date: 2019/8/29
 * @Description:
 */
@Configuration // 告诉spring这是一个配置类
@ComponentScan(value = "jie.blog.source.springcore.busniess"
//        includeFilters =  {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
//        useDefaultFilters = false
        )
public class MainConfig {
    @Bean(value = "pp") // 给容器注册一个bean 类型 ：返回值 ，id:默认使用方法名
    public Person person() {
        Person person = new Person();
        person.setAge(24);
        person.setName("ajie");
        return person;
    }

    @Bean
    public CarFactoryBean carFactoryBean() {
        return  new CarFactoryBean();
    }
}