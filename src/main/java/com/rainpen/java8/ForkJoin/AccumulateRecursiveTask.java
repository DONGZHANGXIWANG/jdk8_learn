package com.rainpen.java8.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2017/12/12/012.
 */
public class AccumulateRecursiveTask extends RecursiveTask<Integer> {

    private final int start;
    private final int end;
    private final int [] data;
    private final int LIMIT = 3;

    public AccumulateRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }


    @Override
    protected Integer compute() {

        if((end-start) <= LIMIT){
            int result = 0;
            for (int i = start; i < end; i++) {
                result += data[i];
            }
            return result;
        }

        int mid = (start + end) / 2;
        AccumulateRecursiveTask left = new AccumulateRecursiveTask(start, mid,data);
        AccumulateRecursiveTask right = new AccumulateRecursiveTask(mid, end,data);
        left.fork();
        right.fork();
        //Integer rightResult = right.compute();
        Integer rightResult = right.join();
        Integer leftResult = left.join();
        return rightResult + leftResult;
    }
}
