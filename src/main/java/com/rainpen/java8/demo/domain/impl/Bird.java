package com.rainpen.java8.demo.domain.impl;

import com.rainpen.java8.demo.domain.Animal;

/**
 * @author laiyup-S9644
 * @date 2020年10月28日
 */
public class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior() {
        System.out.println("fly");
    }
}
