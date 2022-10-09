package com.ilf.msbdesignmode.singleton;

/**
 * @program: msb-design-mode
 * @description: enum 方式解决单例，还防止反序列化（不知道为啥会防止
 * @author: carl.zhang
 * @create: 2022-10-09  21:42
 **/
public enum Mgr08 {
    INSTANCE;

    public void m() {
        System.out.println("业务方法");
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
