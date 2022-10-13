package com.ilf.msbdesignmode.strategy;

import java.util.Comparator;

/**
 * @program: msb-design-mode
 * @description: 排序类
 * @author: carl.zhang
 * @create: 2022-10-13  21:47
 **/
public class Sort<T> {

    public T[] sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (comparator.compare(arr[i], arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    private void swap(T[] arr, int i, int j) {
        T item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }


}
