package com.us.lot.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable[] jobs = {
                new MyCallable(100),
                new MyCallable(1000),
                new MyCallable(10000),
                new MyCallable(200),
                new MyCallable(2000),
                new MyCallable(3000),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyCallable job : jobs){
            Future future = service.submit(job);
            System.out.println(future.get());
        }
        service.shutdown();
    }
}

class MyCallable implements Callable{
    int num;

    public MyCallable(int num){
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is.... responsible to find sum of first "+ num + "numbers");
        int sum = 0;
        for (int i=1 ; i<=num ; i++){
            sum+= i;
        }
        return sum;
    }
}
