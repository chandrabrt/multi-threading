package com.us.lot.priority;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class ThreadPriority implements Runnable {
    @Override
    public void run() {

    }
}

class PriorityMain{

    public static void main(String[] args) {
        System.out.println("default priority main thread: "+ Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(7);
        System.out.println("after setting parent priority: "+ Thread.currentThread().getPriority());

        ThreadPriority runnable = new ThreadPriority();
        Thread thread = new Thread(runnable);

        System.out.println("Child priority: "+ thread.getPriority());

    }
}
