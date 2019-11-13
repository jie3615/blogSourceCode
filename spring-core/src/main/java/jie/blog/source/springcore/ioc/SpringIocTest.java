package jie.blog.source.springcore.ioc;

import jie.blog.source.springcore.bean.Person;
import jie.blog.source.springcore.config.MainConfig;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author: wyj
 * @date: 2019/11/11
 * @description:
 */
public class SpringIocTest {
    public static void main(String[] args){

        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        Person person = (Person) defaultListableBeanFactory.getBean("person");
        System.out.println(person);
        Person person1 = (Person) defaultListableBeanFactory.getBean("person");
        System.out.println(person1==person);
    }

    @Test
    public void test001() {        // 等同于main方法
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Person person = (Person) factory.getBean("person");
        System.out.println(person);
    }

    /**
     * 以下为ApplicationContext的实现，会提供更多的功能
     */
    @Test
    public void test() {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        //2. 从 IOC 容器中获取 bean 的实例
        Person person = (Person) ctx.getBean("person");
        //是通过bean.xml里面定义的id来定位获取哪个bean实例的。@lcb
        System.out.println(person);
    }


    @Test
    public void test01() {
            MockServletContext sc = new MockServletContext("");
            XmlWebApplicationContext root = new XmlWebApplicationContext();
            root.setServletContext(sc);
            root.setConfigLocations(new String[] {"beans.xml"});
            root.refresh();
            Person person = (Person) root.getBean("person");
            System.out.println(person);
           /* XmlWebApplicationContext wac = new XmlWebApplicationContext();
            wac.setParent(root);
            wac.setServletContext(sc);
            wac.setNamespace("map2err");
            wac.setConfigLocations(new String[] {"/org/springframework/web/servlet/handler/map2err.xml"});
            wac.refresh();
            fail("Should have thrown NoSuchBeanDefinitionException");*/

        }
    @Test
    public void test02() {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
            Person bean = applicationContext.getBean(Person.class);
            System.out.println(bean);
    }

    @Test
    public void test03() {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("classpath:beans.xml");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }
}