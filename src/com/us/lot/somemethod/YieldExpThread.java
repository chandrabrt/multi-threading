package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class YieldExpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Child thread");
            Thread.yield();
        }
    }
}

class Demo {

    public static void main(String[] args) {
        YieldExpThread t = new YieldExpThread();
        t.start();
        for (int i = 0; i <= 10; i++) {
            System.out.println("Main thread");
        }

    }
}
