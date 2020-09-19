package com.us.lot.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class Demo {
    public static void main(String[] args) {
        MyRunnable[] jobs = {
                new MyRunnable("chandra"),
                new MyRunnable("Shaym"),
                new MyRunnable("Hari"),
                new MyRunnable("Ram"),
                new MyRunnable("Gita"),
                new MyRunnable("Sita"),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyRunnable job :jobs){
            service.submit(job);
        }
        service.shutdown();
    }
}

class MyRunnable implements Runnable {
    String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "...job started by thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ".. job completed by thread: " + Thread.currentThread().getName());
    }
}
