package com.ilf.msbdesignmode.strategy;

import java.util.Comparator;

/**
 * @program: msb-design-mode
 * @description: 狗的 高度比较策略
 * @author: carl.zhang
 * @create: 2022-10-13  22:02
 **/
public class DogHeightComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getHeight() > o2.getHeight()) {
            return -1;
        } else if (o1.getHeight() < o2.getHeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
