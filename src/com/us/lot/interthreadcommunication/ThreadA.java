package com.us.lot.interthreadcommunication;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */

public class ThreadA {
    public static void main(String[] args) throws Exception {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b){
            System.out.println("1. Main thread calling the wait method");
            b.wait();
            System.out.println("4. Main thread got notification");
            System.out.println(b.total);

        }
    }
}

class ThreadB extends Thread{
    int total = 0;

    @Override
    public void run() {
        synchronized (this){
            System.out.println("2. child start calculation");
            for (int i=1; i<=100; i++){
                total+=i;
            }
            System.out.println("3. child thread giving notification");
            this.notify();
        }
    }
}
