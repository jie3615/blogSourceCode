package jie.blog.source.springcore.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: wyj
 * @date: 2019/8/31
 * @description:
 */
@Component
public class Cat implements InitializingBean,DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("cat destory");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("cat init");
    }
}