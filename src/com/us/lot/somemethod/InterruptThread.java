package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-15
 */
public class InterruptThread  extends Thread{
    @Override
    public void run() {
        for (int i = 1; i<10000; i++){
            System.out.println("I'm lazy thread: "+i);
        }
        System.out.println("I want to sleep");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        InterruptThread t = new InterruptThread();
        t.start();

        t.interrupt();
        System.out.println("end of main");
    }
}
