package com.rainpen.java8.demo;

import com.rainpen.java8.demo.domain.Animal;
import com.rainpen.java8.demo.domain.impl.Bird;
import com.rainpen.java8.demo.domain.impl.Dog;

import java.util.function.BiFunction;

/**
 * 方法引用 - 3.构造方法引用
 *
 * @author laiyup-S9644
 * @date 2020年10月28日
 */
public class MethodReference3 {

    public static void main(String[] args) {
        // 传统方法
        MethodReferenceFactory methodReferenceFactory = new MethodReferenceFactory() {
            @Override
            public Animal createAnimal(String name, int age) {
                return new Dog(name, age);
            }
        };
        Animal alias = methodReferenceFactory.createAnimal("alias", 3);

        methodReferenceFactory = new MethodReferenceFactory() {
            @Override
            public Animal createAnimal(String name, int age) {
                return new Bird(name, age);
            }
        };
        methodReferenceFactory.createAnimal("smook", 2);

        MethodReferenceFactory methodReferenceFactory1 = Dog::new;
        methodReferenceFactory1.createAnimal("alias", 4);
        methodReferenceFactory1.createAnimal("smook", 2);
    }
}
