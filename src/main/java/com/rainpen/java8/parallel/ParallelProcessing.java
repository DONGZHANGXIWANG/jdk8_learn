package com.rainpen.java8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行测试
 * Created by Administrator on 2017/12/12/012.
 */
public class ParallelProcessing {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        System.out.println("The Processing time(normalAdd) => " + measureSumPerformance(ParallelProcessing::normalAdd, 10_000_000) + "ms");
        System.out.println("The Processing time(itrateStream) => " + measureSumPerformance(ParallelProcessing::itrateStream, 10_000_000) + "ms");
        System.out.println("The Processing time(parallelStream) => " + measureSumPerformance(ParallelProcessing::parallelStream, 10_000_000) + "ms");
        System.out.println("The Processing time(parallelStream2) => " + measureSumPerformance(ParallelProcessing::parallelStream2, 10_000_000) + "ms");
        System.out.println("The Processing time(parallelStream3) => " + measureSumPerformance(ParallelProcessing::parallelStream3, 10_000_000) + "ms");
        /*8
        The Processing time(normalAdd) => 3ms
        The Processing time(itrateStream) => 85ms
        The Processing time(parallelStream) => 110ms
        The Processing time(parallelStream2) => 152ms
        The Processing time(parallelStream3) => 1ms*/
        //从上面结果看出，并行（parallel）并不是对所有方法都是友好的，需要自己去了解
    }

    private static long measureSumPerformance(Function<Long,Long> adder, long limit){
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();
            long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimestamp;
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    private static long normalAdd(long limit){
        long result = 0L;
        for (long i = 1L; i < limit; i++) {
            result += i;
        }
        return result;
    }

    private static long itrateStream(long limit){
        return Stream.iterate(1L, i -> i+1).limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream(long limit){
        return Stream.iterate(1L, i -> i+1).parallel().limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream2(long limit){
        return Stream.iterate(1L, i -> i+1).mapToLong(Long::longValue).parallel().limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream3(long limit){
        return LongStream.rangeClosed(1,limit).parallel().limit(limit).reduce(0L, Long::sum);
    }
}
