package com.rainpen.java8.stream;

import com.rainpen.java8.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/12/4/004.
 */
public class Demo {

    public static void main(String[] args) {
        //1.collect(toList())方法从stream里的值生成一个列表
        List<String> list = Stream.of("a", "b", "c").collect(toList());
        System.out.println(list);

        /*
        * 2.map函数将一种类型的值转换成另一种类型
        * map()中的参数是一个Function的函数式的接口，这个接口就是将一个数转换成另外一个数
        */
        List<String> collect = Stream.of("a", "b", "hello").map(stringStr -> stringStr.toUpperCase()).collect(toList());
        System.out.println(collect);

        //3.filter
        //idDigit()方法用于判断指定字符是否为数字
        List<String> collect1 = Stream.of("a", "1hello", "dd2").filter(value -> Character.isDigit(value.charAt(0))).collect(toList());
        System.out.println(collect1);

        //4.flatMap
        List<Integer> collect2 = Stream.of(Arrays.asList(1, 3), Arrays.asList(3, 8)).flatMap(slist -> slist.stream()).collect(toList());
        System.out.println(collect2);

        //5.max/min
        List<Apple> apples = Arrays.asList(new Apple("red",100),new Apple("yellow", 60), new Apple("black",150));
        Apple apple1 = apples.stream().min(Comparator.comparing(apple -> apple.getWeigth())).get();
        assertEquals(apples.get(1),apple1);

        //6.reduce
        int count = Stream.of(1,2,3).reduce(0, (total,num) -> total + num);
        System.out.println(count);
    }

}
