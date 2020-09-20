package com.us.lot.v2.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //submit the task for execution
        List<Future> allFutures = new ArrayList<>();
        for (int i=0; i<=100; i++){
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }
        //100 futures with 100 placeholder

        //perfom  some un-related operations
        for (int i=0; i<=100; i++){
            Future<Integer> future = allFutures.get(i);
            Integer result = future.get(); //blocking operations
            System.out.println("Result of future # "+ i+ "="+ result);
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
