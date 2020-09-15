package com.us.lot.implementrunable;

/**
 * @author chandra khadka
 * @since 2020-09-12
 */
public class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Child");
    }
}

class  Demo{
    public static void main(String[] args) {
        //Runnable
        MyRunnableThread myThread = new MyRunnableThread();

        Thread t1 = new Thread(myThread);
        t1.start();

        System.out.println("hello");
    }
}