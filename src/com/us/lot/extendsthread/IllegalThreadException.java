package com.us.lot.extendsthread;
/**
 * @author chandra khadka
 * @since  2020-09-13
 */
public class IllegalThreadException extends Thread{
    @Override
    public void run() {
        //job of thread
        System.out.println("Child Thread:");
    }
}

class Demo{
    public static void main(String[] args) {
        IllegalThreadException t = new IllegalThreadException();
        t.start();
        System.out.println("Main Thread");
        t.start();//IllegalThreadStateException
    }
}
