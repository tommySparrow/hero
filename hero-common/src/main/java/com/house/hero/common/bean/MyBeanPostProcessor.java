package com.house.hero.common.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 验证spring bean的生命周期
 * @author User
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 容器加载的时候会加载一些其他的bean，会调用初始化前和初始化后方法
    // 这次只关注book(bean)的生命周期
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof Book){
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization---6:BeanPostProcessor初始化前(容器加载的时候同时会加载一些其他的bean，会调用初始化前和初始化后方法)");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Book){
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization---10:BeanPostProcessor初始化后(容器加载的时候同时会加载一些其他的bean，会调用初始化前和初始化后方法)");
        }
        return bean;
    }
}
