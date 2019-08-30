package jie.blog.source.springcore.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: wyj
 * @Date: 2019/8/29
 * @Description:
 */
public class IOCAutoConfigTest {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Object carFactoryBean = applicationContext.getBean("carFactoryBean");
        System.out.println(applicationContext.containsBean("carFactoryBean"));
        // 想拿到CarFactoryBean对象
        Object carFac = applicationContext.getBean("&carFactoryBean");
        System.out.println(carFac);
        System.out.println("carFactoryBean的类型："+carFactoryBean.getClass());
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        /**
         * 执行结果
         * org.springframework.context.event.internalEventListenerFactory
         mainConfig
         manageController
         manageDao
         manageService
         pp

         Process finished with exit code 0

         */
        /**
         * excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class} 制定排除对象
         * 。。。includeFilters...
         */
    }
}