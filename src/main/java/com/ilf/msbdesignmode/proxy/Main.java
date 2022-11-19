package com.ilf.msbdesignmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: msb-design-mode
 * @description: 代理
 * @author: carl.zhang
 * @create: 2022-11-19  21:44
 **/
public class Main {

    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        Moveable m = (Moveable) Proxy.newProxyInstance(tank.getClass().getClassLoader(), new Class[]{Moveable.class},
                //        new LogHandler(tank)
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("start...");
                        Object o = method.invoke(tank, args);
                        System.out.println("end...");
                        return o;
                    }
                }
        );
        m.move();
    }


    //通过二进制字节码分析类的属性，jdk 能力提供的动态代理


}

class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy invoke ,method is" + method.getName() + "start ...");
        Object o = method.invoke(tank, args);
        System.out.println("proxy invoke ,method is" + method.getName() + "end ...");
        return o;
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