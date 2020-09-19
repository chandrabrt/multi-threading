package com.us.lot.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class DemoTryLock {
    public static void main(String[] args) {
        MyThreads t1 = new MyThreads("first thread");
        MyThreads t2 = new MyThreads("second thread");
        t1.start();
        t2.start();
    }
}

class MyThreads extends Thread {
    static ReentrantLock l = new ReentrantLock();

    public MyThreads(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (l.tryLock()){
            System.out.println(Thread.currentThread().getName() + ": get lock and performing safe operation");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.unlock();
        }else {
            System.out.println(Thread.currentThread().getName() + ": unable to get lock and hence performing alternative " +
                    "operation");
        }
    }
}