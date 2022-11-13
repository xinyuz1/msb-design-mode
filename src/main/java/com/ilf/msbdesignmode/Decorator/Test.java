package com.ilf.msbdesignmode.Decorator;

/**
 * @program: msb-design-mode
 * @description: 装饰器
 * @author: carl.zhang
 * @create: 2022-11-13  15:51
 **/
public class Test {

    public static void main(String[] args) {
        //子弹装饰了 矩形+尾巴
        Bullet bullet = new Bullet();
        RectDecorator r = new RectDecorator(bullet); //矩形装饰
        TailDecorator t = new TailDecorator(r); //尾巴装饰

//        怎么使用，还需要考虑一下
//        bullet.palnt();
//        t.palnt(new Graphis("green"));

        /**&
         * 5个猴山
         * 三座 金丝猴  x = 120
         * 两个 猕猴  y  = 40
         *
         * 10  15  30  35  70
         *
         * 金丝猴 是 泥猴的三倍
         *
         * x +y = 3y+y
         *
         * x+y = (10  15  30  35  70)
         *
         int y = (10 + 15 + 30 + 35 + 70) / 4;

         System.out.println(y);
         */

    }

}

/**
 * 画图 方法的共通参数
 * 整个对象根据不同的项目而定
 */
class Graphis {
    public String color;

    public Graphis(String color) {
        this.color = color;
    }
}

/**
 * 整个项目的 对象的一个抽象
 * 可以是接口或者抽象方法，甚至是普通类，都行
 */
interface GameObject {
    /**
     * 所有对象，固有属性
     */
    int x = 0, y = 0;

    void palnt(Graphis g);
}

/**
 * 子弹 类，继承项目的抽象对象
 * 并实现自己的 画图方法
 */
class Bullet implements GameObject {

    @Override
    public void palnt(Graphis g) {
        System.out.println("bullet pic");
    }
}


/**
 * gameObject 的装饰器 ，抽象
 * 1\实现  game object ，完成game object 的能力，完成的方式就是装饰的过程
 * 2\引用 game object ，可以做到所有的 game object 的子类都能被装饰
 */
class GODecorator implements GameObject {
    GameObject go;

    @Override
    public void palnt(Graphis g) {
        go.palnt(g);
    }
}


/**
 * 矩形 装饰器
 */
class RectDecorator extends GODecorator {

    RectDecorator(GameObject go) {
        this.go = go;
    }

    /**
     * 装饰 一个矩形操作
     *
     * @param g
     */
    @Override
    public void palnt(Graphis g) {
        System.out.println("add rect");
    }
}

/**
 * 尾巴 装饰器
 */
class TailDecorator extends GODecorator {

    TailDecorator(GameObject go) {
        this.go = go;
    }

    /**
     * 装饰 一个尾巴操作
     *
     * @param g
     */
    @Override
    public void palnt(Graphis g) {
        System.out.println("add tail");
    }
}