package com.rainpen.java8.demo;

/**
 * 方法引用 - 1.静态方法引用
 * @author laiyup-S9644
 * @date 2020年10月28日
 */
public class MethodReference1 {

    public static void main(String[] args) {
        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return MethodReference1.String2Int(from);
            }
        };
        Integer convert = converter.convert("120");

        Converter<String, Integer> converter2 = MethodReference1::String2Int;
        Integer convert1 = converter2.convert("120");
    }

    /**
     * 函数接口
     * @param <F>
     * @param <T>
     */
    @FunctionalInterface
    interface Converter<F,T>{
        T convert(F from);
    }

    /**
     * 语句块
     * @param from
     * @return
     */
    static int String2Int(String from){
        return Integer.parseInt(from);
    }
}
