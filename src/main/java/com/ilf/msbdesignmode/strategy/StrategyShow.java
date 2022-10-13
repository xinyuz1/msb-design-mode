package com.ilf.msbdesignmode.strategy;

import java.util.Arrays;

/**
 * @program: msb-design-mode
 * @description: 策略模式展示
 * @author: carl.zhang
 * @create: 2022-10-13  22:05
 **/
public class StrategyShow {

    /**
     * 此为策略模式，
     * 将对比的能力提炼出来。用来完成 可变策略。
     * 实例中，定义 通过狗的高度和年龄 对比两个策略
     * @param args
     */
    public static void main(String[] args) {
        Dog d1 = new Dog(10, 3);
        Dog d2 = new Dog(14, 1);
        Dog d3 = new Dog(17, 6);
        Dog d4 = new Dog(19, 2);

        Dog[] arr = {d1, d2, d3, d4};

        Sort<Dog> sort = new Sort<>();
        Dog[] dogs = sort.sort(arr, new DogAgeComparator());

        for (int a = 0; a < dogs.length; a++) {
            System.out.println(arr[a].toString());
        }
    }
}
