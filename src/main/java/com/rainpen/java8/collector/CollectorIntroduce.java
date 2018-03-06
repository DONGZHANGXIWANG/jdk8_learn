package com.rainpen.java8.collector;

import com.rainpen.java8.Apple;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2017/12/11/011.
 */
public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170),
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170));

        List<Apple> greenApple = list.stream().filter(apple -> apple.getColor().equals("green")).collect(toList());
        Optional.ofNullable(greenApple).ifPresent(System.out::println);
        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
        Optional.ofNullable(groupByCollectors(list)).ifPresent(System.out::println);
    }


    public static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple apple : apples
                ) {
            List<Apple> list = map.get(apple.getColor());
            if (list == null) {
                list = new ArrayList<>();
                map.put(apple.getColor(), list);
            }
            list.add(apple);
        }
        return map;
    }

    public static Map<String, List<Apple>> groupByFunction(List<Apple> apples){
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(apple -> {
            List<Apple> colorList = Optional.ofNullable(map.get(apple.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(apple.getColor(), list);
                return list;
            });
            colorList.add(apple);
        });
        return map;
    }

    public static Map<String, List<Apple>> groupByCollectors(List<Apple> apples){
        //return apples.stream().collect(Collectors.groupingBy(apple -> apple.getColor()));
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
