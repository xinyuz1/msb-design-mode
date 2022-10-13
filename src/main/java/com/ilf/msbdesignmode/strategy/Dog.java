package com.ilf.msbdesignmode.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: msb-design-mode
 * @description: 狗
 * @author: carl.zhang
 * @create: 2022-10-13  21:56
 **/
@Data
@NoArgsConstructor
public class Dog {
    private int height;
    private int age;

    public Dog(int height,int age){
        this.height=height;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                ", age=" + age +
                '}';
    }
}
