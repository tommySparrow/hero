package com.house.hero.java;

import com.house.hero.common.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring bean创建销毁启动类
 * @author User
 */
public class SpringBeanLifecycleApplication {

    public static void main(String[] args) throws InterruptedException {
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
        Book book = (Book)context.getBean("book");
        System.out.println("Book name = " + book.getBookName()+"---11:bean实例化完成并使用");
        ((ClassPathXmlApplicationContext) context).destroy();

    }
}
