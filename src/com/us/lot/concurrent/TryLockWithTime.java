package com.us.lot.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class TryLockWithTime {

    public static void main(String[] args) {
        MyThreads1 t1 = new MyThreads1("first thread");
        MyThreads1 t2 = new MyThreads1("second thread");
        t1.start();
        t2.start();
    }
}

class MyThreads1 extends Thread {
    static ReentrantLock l = new ReentrantLock();

    public MyThreads1(String name) {
        super(name);
    }

    @Override
    public void run() {
        do {
            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName() + ": got lock");
                    Thread.sleep(30000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName() + ": releases thread");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + ": unable to get lock and will try again");
                }
            }catch (Exception e){
                System.out.println("error");
            }
        }while (true);
    }
}