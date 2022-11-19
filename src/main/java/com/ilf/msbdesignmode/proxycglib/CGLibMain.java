package com.ilf.msbdesignmode.proxycglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: msb-design-mode
 * @description: 代理
 * @author: carl.zhang
 * @create: 2022-11-19  21:44
 **/
public class CGLibMain {

    public static void main(String[] args) {
        Tank tank = new Tank();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogHandler(new Tank()));
        Tank m = (Tank) enhancer.create();
        m.move();
    }


    //通过二进制字节码分析类的属性，jdk 能力提供的动态代理


}

class LogHandler implements MethodInterceptor {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy invoke ,method is" + method.getName() + "  start ...");
        Object om = methodProxy.invokeSuper(o, objects);
        System.out.println("proxy invoke ,method is" + method.getName() + "  end ...");
        return om;
    }
}

class Tank implements Moveable {

    @Override
    public void move() {
        System.out.println("kalakalakala");
    }
}

interface Moveable {
    void move();
}