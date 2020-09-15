package com.us.lot.priority;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class PrioritySet implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Child thread");
        }
    }
}

class PrioritySetDemo{

    public static void main(String[] args) {
        System.out.println("default priority main thread: "+ Thread.currentThread().getPriority());

        PrioritySet runnable = new PrioritySet();
        Thread t = new Thread(runnable);
        //set priority to child thread
        t.setPriority(7);
        System.out.println(" "+ t.getPriority());
        t.start();

        for (int i=0; i<10; i++) {
            System.out.println("Main thread");
        }
    }
}
