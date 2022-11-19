package com.ilf.spring.v1;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @program: msb-design-mode
 * @description: tank
 * @author: carl.zhang
 * @create: 2022-11-19  23:03
 **/

public class Tank {

    public void move() {

        System.out.println("tank move  ka la ka la ka la ....");

        try {
            Thread.sleep(Long.valueOf(new Random().nextInt(10000)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
