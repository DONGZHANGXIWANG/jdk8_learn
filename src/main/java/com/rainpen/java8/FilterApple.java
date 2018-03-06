package com.rainpen.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Adler32;

/**
 * Created by Administrator on 2017/11/30/030.
 */
public class FilterApple {


    /* ==============使用策略模式start============== */
    @FunctionalInterface
    public interface AppleFilter{
        boolean filter(Apple apple);
    }
    public static class GreenAnd150WeigthFilter implements AppleFilter{
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeigth() >= 150);
        }
    }
    public static List<Apple> findApple(List<Apple> apples, AppleFilter filter){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: apples) {
            if (filter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }
    /* ==============使用策略模式end============== */

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("green",150), new Apple("green", 120), new Apple("yellow", 180));

        List<Apple> apple = findApple(appleList, new GreenAnd150WeigthFilter());
        System.out.println(apple);

        //使用匿名内部类,简化了策略模式的繁琐实现类（一种过滤方式就要创建一个接口的实现）
        List<Apple> yellow = findApple(appleList, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return apple.getColor().equals("yellow");
            }
        });
        System.out.println(yellow);

        //使用lambda表达式
        List<Apple> green = findApple(appleList, (Apple apples) -> {
            return apples.getColor().equals("green");
        });
        System.out.println(green);

        //JDK1.8后runnable接口加了@FunctionalInterface修饰
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //写法可以用lambda表达式
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
