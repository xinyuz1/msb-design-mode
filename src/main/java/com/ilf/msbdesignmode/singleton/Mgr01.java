package com.ilf.msbdesignmode.singleton;

/*
 * 最简单的安全的单例方式之一。唯一缺点是无论用到与否都会被实例化，浪费了内存
 * 类加载到内存后，jvm会主动执行 static 变量实例化。并且static变量是统一内存存储
 * 因此无论被加载多少次，都会只有一个实例
 *
 * @program: msb-design-mode
 * @description: 单例01- 静态
 * @author: carl.zhang
 * @create: 2022-10-09  21:16
 **/
public class Mgr01 {

    /**
     * volatile
     * 防止java指令重排，导致的未实例化之前，就被返回了变量。JIT -java in time 时候，实例化指令被排到返回结果（上游获取变量）之前了。
     */
    public static volatile Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

}
