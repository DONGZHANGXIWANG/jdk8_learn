package com.rainpen.java8.stream;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/12/7/007.
 */
public class CreateStream {

    public static void main(String[] args) {
        /*createStreamFromCollection().forEach(System.out::println);
        createStreamFromOf().forEach(System.out::println);
        createStreamFromArray().forEach(System.out::println);

        Stream<String> streamFromFile = createStreamFromFile();
        System.out.println(streamFromFile);*/

        createStreamFromIterator().forEach(System.out::println);
        createStreamFromGenerate().forEach(System.out::println);
    }


    /*Generate the Stream Object From Collection*/
    private static Stream<String> createStreamFromCollection(){
        List<String> list = Arrays.asList("hello","adam","create","by","rainpen");
        return list.stream();
    }

    private static Stream<String> createStreamFromOf(){
        return Stream.of("hello","adam","create","by","rainpen");
    }

    private static Stream<String> createStreamFromArray(){
        String[] strings = {"hello","adam","create","by","rainpen"};
        return Arrays.stream(strings);
    }

    private static Stream<String> createStreamFromFile(){
        Path path = Paths.get("D:\\mybatis_generator\\jdk8_learn\\src\\main\\java\\com\\rainpen\\java8\\stream\\Demo.java");
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(10);
        return limit;
    }

    private static Stream<Double> createStreamFromGenerate(){
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        return limit;
    }

}
