package com.rainpen.java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author laiyup-S9644
 * @date 2020年10月30日
 */
public class LambdaSyntaxDemo {

    public void syntax(){
        // 实例1： 不需要接收参数，直接返回10.
        Supplier<Integer> supplier = () -> 10;
        System.out.println("不接收参数，返回值:" + supplier.get());

        // 实例2：接收两个int类型的参数，并返回这两个数相加的结果
        BinaryOperator<Integer> binaryOperator = (Integer x, Integer y) -> x+y;

        // 实例2：类型推断
        BinaryOperator<Integer> binaryOperator2 =(x, y) -> x + y;

        // 实例3：接收参数，不返回结果
        Consumer<String> stringConsumer = (str) -> System.out.println(str);


    }

}
