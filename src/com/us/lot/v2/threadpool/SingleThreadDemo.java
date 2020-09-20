package com.us.lot.v2.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class SingleThreadDemo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i= 1; i<=100; i++){
            service.submit(new CPUIntensiveDemo.CPUIntensiveTask());
        }
        service.shutdown();
    }

    static class SingleThreadPool implements Runnable{
        @Override
        public void run() {
            System.out.println("Some operations: "+ Thread.currentThread().getName());
        }
    }
}
