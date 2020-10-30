package com.rainpen.java8.demo;

import com.rainpen.java8.demo.domain.Animal;

/**
 * 函数接口
 *
 * @author laiyup-S9644
 * @date 2020年10月28日
 */
@FunctionalInterface
public interface MethodReferenceFactory<T extends Animal> {

    /**
     * 目标方法
     * @param name
     * @param age
     * @return
     */
    T createAnimal(String name, int age);

}
