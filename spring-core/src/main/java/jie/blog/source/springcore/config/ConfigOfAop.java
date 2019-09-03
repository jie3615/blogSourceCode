package jie.blog.source.springcore.config;

import jie.blog.source.springcore.aop.LogAspect;
import jie.blog.source.springcore.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: wyj
 * @date: 2019/9/3
 * @description:
 */
@Configuration
@EnableAspectJAutoProxy
public class ConfigOfAop {
    @Bean
    public MathCalculator calculator() {
        return  new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return  new LogAspect();
    }
}