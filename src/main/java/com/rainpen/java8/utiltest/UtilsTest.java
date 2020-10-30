package com.rainpen.java8.utiltest;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author laiyup-S9644
 * @date 2020年10月29日
 */
public class UtilsTest {

    /**
     * Predicate 输入一个参数，并返回一个Boolean值，其中内置许多用于逻辑判断的默认方法
     */
    @Test
    public void predicateTest(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean test = predicate.test("test");
        System.out.println("字符串长度大于0: " + test);

        test = predicate.test("");
        System.out.println("字符串长度大于0: " + test);

        test = predicate.negate().test("");
        System.out.println("字符串长度小于0: " + test);

        Predicate<Object> pre = Objects::nonNull;
        Object ob = null;
        test = pre.test(ob);
        System.out.println("对象不为空：" + test);
        ob = new Object();
        test = pre.test(ob);
        System.out.println("对象不为空：" + test);
    }

    /**
     * 接收一个参数，返回单一的结果，默认方法(andThen)可将多个函数串在一起，形成复合Function(有输入，有输出)结果
     */
    @Test
    public void functionTest(){
        Integer.valueOf("123");
        Function<String, Integer> toInteger = Integer::valueOf;
        // toInteger的执行结果作为第二个backToString的输入
        Function<String, String> backToString = toInteger.andThen(String :: valueOf);

        Predicate<String> je = (a) -> a.equals("123");
        boolean test = je.test("312");




    }







}
