package com.us.lot.extendsthread;

/**
 * @author chandra khadka
 * @since 2020-09-12
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        //job of thread
        for (int i =0; i<=100; i++){
            System.out.println("Child Thread:"+ i);
        }
    }
}
