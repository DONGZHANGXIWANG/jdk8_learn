package com.rainpen.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Administrator on 2017/11/30/030.
 */
public class LambdaExpression {


    public static String testFunction(Apple apple, Function<Apple,String> function){
        return function.apply(apple);
    }

    public static void main(String[] args) {

        Function<String, Integer> stringConsumer = (String s) -> s.length();

        String red = testFunction(new Apple("red", 150), apple -> apple.toString());
        System.out.println(red );



        List<Apple> list = Arrays.asList(new Apple("abc",123),new Apple("Green",150),new Apple("red",80));
        /*list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });*/
        System.out.println(list);
        list.sort(((o1, o2) -> o1.getColor().compareTo(o2.getColor())));    //(参数) -> 逻辑表达式
        System.out.println(list);

        System.out.println("=============================函数推导=============乱码===================");
        list.stream().forEach(apple -> System.out.println(apple));
        list.stream().forEach(System.out::println);

        //1.静态方法
        int val = Integer.parseInt("123");
        Function<String,Integer> f = Integer::parseInt;
        Integer val2 = f.apply("123");
        System.out.println(val + "," + val2);

        //2.对任意类型的实例方法的方法引用
        BiFunction<String, Integer, Character> bf = String::charAt;
        Character character = bf.apply("hello", 2);
        System.out.println(character);

        //3.对现有对象的实例方法的方法引用
        String string = new String("hello");
        Function<Integer, Character> bf2 = string::charAt;
        Character character1 = bf2.apply(2);
        System.out.println(character1);


        List<Apple> list2 = Arrays.asList(new Apple("abc",123),new Apple("Green",150),new Apple("red",80));
        /*list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });*/
        System.out.println(list2);
        list2.sort(Comparator.comparing(Apple::getColor));    //(参数) -> 逻辑表达式
        System.out.println(list2);
    }


}
