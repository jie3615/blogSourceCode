package jie.blog.source.springcore.test;

import jie.blog.source.springcore.aop.MathCalculator;
import jie.blog.source.springcore.config.ConfigOfAop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wyj
 * @date: 2019/9/3
 * @description:
 */
public class AopConfigTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfAop.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 0);
    }
}