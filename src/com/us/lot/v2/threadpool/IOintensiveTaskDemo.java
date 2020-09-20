package com.us.lot.v2.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class IOintensiveTaskDemo {
    public static void main(String[] args) {
        //much higher count need for IO tasks even your cpu core size is less
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 0; i<=100; i++){
            service.execute(new IOTask());
        }
    }

    static class IOTask implements Runnable{

        @Override
        public void run() {
            System.out.println("some IO operation like DB call, http request call, network call which will cause thread " +
                    "to block/wait. : "+ Thread.currentThread().getName());

        }
    }
}
