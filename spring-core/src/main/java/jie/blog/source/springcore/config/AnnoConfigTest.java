package jie.blog.source.springcore.config;

import jie.blog.source.springcore.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: wyj
 * @Date: 2019/8/29
 * @Description:使用注解读取bean容器
 */
public class AnnoConfigTest {
    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);

        }
    }
}