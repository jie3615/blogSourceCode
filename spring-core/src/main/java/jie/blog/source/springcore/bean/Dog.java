package jie.blog.source.springcore.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: wyj
 * @date: 2019/8/31
 * @description:
 */
@Component
public class Dog {
    private Dog() {
        System.out.println("dog 构造器");
    }

    @PostConstruct
    private void init() {
        System.out.println("dog init");
    }

    @PreDestroy
    private void destory() {
        System.out.println("dog destory");
    }

}