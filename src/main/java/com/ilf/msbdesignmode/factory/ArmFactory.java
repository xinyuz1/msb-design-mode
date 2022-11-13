package com.ilf.msbdesignmode.factory;

/**
 * @program: msb-design-mode
 * @description: 实例工厂
 *       所以需要定义 实际类，分别继承 food ，weapon ，fly 作为工厂的一个族。
 *       可以纵向扩展 每个族中的每个抽象能力，也可横向扩展 族的能力数量
 * @author: carl.zhang
 * @create: 2022-10-17  21:51
 **/
public class ArmFactory extends AbstractFactory {
    @Override
    AbstractFood getFood() {
        //返回 继承了AbstractFood 的实际的类。下同

        return null;
    }

    @Override
    AbstractWeapon getWeapon() {
        return null;
    }

    @Override
    AbstractFly getFly() {
        return null;
    }
}
