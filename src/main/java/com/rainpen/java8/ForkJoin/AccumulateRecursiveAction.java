package com.rainpen.java8.ForkJoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/12/12/012.
 */
public class AccumulateRecursiveAction extends RecursiveAction {

    private final int start;
    private final int end;
    private final int [] data;
    private final int LIMIT = 3;

    public AccumulateRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if((end-start) <= LIMIT){
            for (int i = start; i < end; i++) {
                AccumulateHelper.accumulate(data[i]);
            }
        }else {
            int mid = (start + end) / 2;
            AccumulateRecursiveAction left = new AccumulateRecursiveAction(start,mid,data);
            AccumulateRecursiveAction right = new AccumulateRecursiveAction(mid,end,data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }


    static class AccumulateHelper{

        private static final AtomicInteger result = new AtomicInteger(0);

        //计算
        static void accumulate(int value){
            result.getAndAdd(value);
        }

        //获取结果
        public static int getResult(){
            return result.get();
        }

        //清空
        static void rest(){
            result.set(0);
        }
    }
}
