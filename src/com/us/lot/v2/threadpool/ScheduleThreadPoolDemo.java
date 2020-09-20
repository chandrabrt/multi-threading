package com.us.lot.v2.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chandra khadka
 * @since 2020-09-20
 */
public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        //for scheduling of task
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        // task to run after 10 second delay
        service.schedule(new ScheduleThreadPool(), 10, TimeUnit.SECONDS);

        //task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new ScheduleThreadPool(), 15, 10, TimeUnit.SECONDS);
//
        //task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new ScheduleThreadPool(), 15, 10, TimeUnit.SECONDS);
    }

    static class ScheduleThreadPool implements Runnable {
        @Override
        public void run() {
            //task that needs to run based on reschedules
            System.out.println("reschedule: " + Thread.currentThread().getName());
        }
    }
}
