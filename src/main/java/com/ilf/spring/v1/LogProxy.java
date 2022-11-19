package com.ilf.spring.v1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: msb-design-mode
 * @description: 日志
 * @author: carl.zhang
 * @create: 2022-11-19  23:05
 **/
@Aspect
public class LogProxy {

    @Before(value = "execution(void com.ilf.spring.v1.Tank.move())")
    public void before() {
        System.out.println("start ... + " + System.currentTimeMillis());
    }

    @After(value = "execution(void com.ilf.spring.v1.Tank.move())")
    public void after() {
        System.out.println("end ... + " + System.currentTimeMillis());
    }
}
