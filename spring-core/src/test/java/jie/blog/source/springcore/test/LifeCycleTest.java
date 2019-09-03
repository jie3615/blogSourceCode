package jie.blog.source.springcore.test;

import jie.blog.source.springcore.config.ConfigOfLifecycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wyj
 * @date: 2019/8/30
 * @description:
 */
public class LifeCycleTest {

    @Test
    public void test001() {
        // 对象创建完成，并且赋值完毕，调用bean 的init方法（单实例有效）
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigOfLifecycle.class);
       /* String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {

            System.out.println(s);
        }*/
       // 多实例情况在getBean调用初始化，关闭不会调用销毁方法
//        annotationConfigApplicationContext.getBean("car01");
        // 容器关闭的时候会调用bean 的destory方法
        annotationConfigApplicationContext.close();
    }
}