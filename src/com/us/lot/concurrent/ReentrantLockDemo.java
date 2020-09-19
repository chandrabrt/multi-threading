package com.us.lot.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "chandra");
        MyThread t2 = new MyThread(d, "Hari");
        t1.start();
        t2.start();
    }
}

class Display{
    ReentrantLock l = new ReentrantLock();
    public void wish(String name){
        l.lock();
        for(int i= 0; i<=10; i++){
            System.out.println("Good morning");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        l.unlock();
    }
}

class MyThread extends Thread{
    Display d;
    String name;

    public MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}