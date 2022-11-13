package com.ilf.msbdesignmode.factory;

/**
 * @program: msb-design-mode
 * @description: 抽象工厂类
 * @author: carl.zhang
 * @create: 2022-10-17  21:49
 **/
public abstract class AbstractFactory {

    abstract AbstractFood getFood();

    abstract AbstractWeapon getWeapon();

    abstract AbstractFly getFly();
}
