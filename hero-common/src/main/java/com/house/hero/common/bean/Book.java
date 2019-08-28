package com.house.hero.common.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 验证spring bean的生命周期
 * @author User
 */
public class Book implements BeanNameAware, BeanFactoryAware,ApplicationContextAware, InitializingBean, DisposableBean {

    private String bookName;
    public Book(){
        System.out.println("Book Initializing---1:调用构造方法创建对象 ");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //回掉提供自己的实例化工厂BeanFactory
        System.out.println("Book.setBeanFactory invoke---4:调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Book.setBeanName invoke---3:调用BeanNameAware的setBeanName设置bean的名称");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Book.destroy invoke---13:调用DisposableBean的destroy");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book.afterPropertiesSet invoke---8:调用InitializingBean的afterPropertiesSet(Invoked by the containing {@code BeanFactory} after it has set all bean properties)");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //将bean所在应用上下文引用传入进来
        System.out.println("Book.setApplicationContext invoke---5:调用ApplicationContextAware的setApplicationContext(将bean所在应用上下文引用传入进来)");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("setBookName: Book name has set.---2:bean属性设置");
    }

    public void myPostConstruct(){
        System.out.println("Book.myPostConstruct invoke---9:bean的init-method(初始化方法)");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("@PostConstruct---7:自定义初始化方法");
    }

    public void myPreDestroy(){
        System.out.println("Book.myPreDestroy invoke---14:自定义的销毁方法被调用");
        System.out.println("---------------destroy-------------> end");
    }

    //自定义销毁方法
    @PreDestroy
    public void springPreDestroy(){
        System.out.println("@PreDestroy---12:实例正在被回收");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}
