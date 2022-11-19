package com.ilf.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: msb-design-mode
 * @description: aop
 * @author: carl.zhang
 * @create: 2022-11-19  22:57
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = applicationContext.getBean("tank", Tank.class);
        tank.move();
    }
}
