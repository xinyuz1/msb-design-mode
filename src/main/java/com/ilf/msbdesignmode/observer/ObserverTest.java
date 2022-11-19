package com.ilf.msbdesignmode.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: msb-design-mode
 * @description: 观察者模式
 * @author: carl.zhang
 * @create: 2022-11-19  20:10
 **/
public class ObserverTest {

    public static void main(String[] args) {

        Child child = new Child();
        child.cry();


    }


}

/**
 * 父亲类
 * 用于监听 孩子哭的动作
 */
class Fa implements Observer {
    @Override
    public String action(CryEvent cryEvent) {
        return "爸爸抱抱";
    }
}

class Ma implements Observer {
    @Override
    public String action(CryEvent cryEvent) {
        return "妈妈喂奶";
    }
}

class Dog implements Observer {
    @Override
    public String action(CryEvent cryEvent) {
        return "旺旺旺";
    }
}

/**
 * 观察者 需要有个统一的接口，
 * 里面定义了 触发的执行内容
 */
interface Observer {

    String action(CryEvent cryEvent);

}

/**
 * 事件，用于被观察
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class CryEvent {

    /**
     * 所处位置
     */
    String location;

    /**
     * 哭声大小 1~10
     */
    int voice;

    /**
     * source 源头， 触发事件的对象
     */
    Child child;


}


/**
 * 被观察者
 */
class Child {

    boolean status = false;

    /**
     * 被观察的事件 哭了
     */
    void cry() {
        status = true;
        System.out.println("child is crying");

        CryEvent cryEvent = new CryEvent("romm", 10, this);


        List<Observer> observers = new ArrayList<>();
        observers.add(new Fa());
        observers.add(new Ma());


        for (int i = 0; i < observers.size(); i++) {
            System.out.println(observers.get(i).action(cryEvent));
        }


    }
}