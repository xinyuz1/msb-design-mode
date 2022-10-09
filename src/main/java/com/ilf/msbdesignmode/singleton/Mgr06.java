package com.ilf.msbdesignmode.singleton;

/**
 * 这个是装逼的写法，不过没有问题，可以使用
 * @program: msb-design-mode
 * @description: double check
 * @author: carl.zhang
 * @create: 2022-10-09  21:32
 **/
public class Mgr06 {
    public static Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE==null){
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

}
