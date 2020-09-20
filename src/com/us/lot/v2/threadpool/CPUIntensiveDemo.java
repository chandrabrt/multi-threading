package com.us.lot.v2.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class CPUIntensiveDemo {
    //based practice
    public static void main(String[] args) {
        //for cpu intensive task assign pool size == tolal number of core
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);

        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        //for lot of short lived  tasks
        //ExecutorService service = Executors.newCachedThreadPool();


        for (int i= 1; i<=10000; i++){
            service.submit(new CPUIntensiveTask());
        }
        service.shutdown();
    }

    static class CPUIntensiveTask implements Runnable{
        @Override
        public void run() {
            System.out.println("Some operations: "+ Thread.currentThread().getName());
        }
    }
}
