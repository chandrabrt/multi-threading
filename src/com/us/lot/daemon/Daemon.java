package com.us.lot.daemon;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class Daemon {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isDaemon());//false
//        Thread.currentThread().setDaemon(true);// IllegalThreadStateException

        MyThread t = new MyThread();
        System.out.println(t.isDaemon());//false
        t.setDaemon(true); //true
        System.out.println(t.isDaemon());//true
    }
}

class MyThread extends Thread{

}