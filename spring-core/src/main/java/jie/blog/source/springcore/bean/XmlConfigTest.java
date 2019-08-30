package jie.blog.source.springcore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: wyj
 * @Date: 2019/8/29
 * @Description:
 */
public class XmlConfigTest {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}