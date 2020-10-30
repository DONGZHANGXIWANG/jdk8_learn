package com.rainpen.java8.demo;

/**
 * 方法引用 - 2.实例方法引用
 *
 * @author laiyup-S9644
 * @date 2020年10月28日
 */
public class MethodReference2 {

    public static void main(String[] args) {
        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer conver(String from) {
                return new Helper().String2Int(from);
            }
        };
        Integer conver = converter.conver("121");

        MethodReference1.Converter<String, Integer> string2Int = new Helper()::String2Int;
        string2Int.convert("313");
    }

    @FunctionalInterface
    interface Converter<F, T>{
        T conver(F from);
    }

    static class Helper{
        public int String2Int(String from){
            return Integer.parseInt(from);
        }
    }
}
