package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-15
 */
public class InterruptSleepThread extends Thread {
    @Override
    public void run() {

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("I am lazy thread");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }
    }
}

class ThreadInterruptedDemo {
    public static void main(String[] args) {
        InterruptSleepThread t = new InterruptSleepThread();
        t.start();

        t.interrupt(); //main thread interrupt the child thread
        System.out.println("End of main thread");
    }
}
