package com.us.lot.v2;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        for (int i =0; i<=100; i++) {
//            Thread t = new Thread(new Task());
//            t.start();
//            Thread.sleep(2000);
//        }
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i =1; i<=10; i++) {
            service.submit(new Task());
        }
        service.shutdown();

    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name: "+ Thread.currentThread().getName());
        }
    }
}
