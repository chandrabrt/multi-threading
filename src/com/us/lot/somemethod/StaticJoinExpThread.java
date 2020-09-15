package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-14
 */
public class StaticJoinExpThread extends Thread {

    static Thread mt; //mt = main thread reference

    @Override
    public void run() {
        try {
            mt.join(); //child thread waiting to complete main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i<=10; i++){
            System.out.println("Child thread");
        }
    }
}

class ThreadJoinDemo{

    public static void main(String[] args) throws InterruptedException {
        StaticJoinExpThread.mt = Thread.currentThread(); //mt point into main thread i.e mt assign Main Thread

        StaticJoinExpThread t = new StaticJoinExpThread();
        t.start();
//        t.join(); //here, main thread is waiting until child thread is completed, this cause dead lock because child thread main thread  both call join method and wait until completed each. so don't call join() method both in child and main thread
        for (int i = 1; i<=10; i++){
            System.out.println("main thread");
            Thread.sleep(2000);
        }
    }
    /*
     * output:
     * main thread
main thread
main thread
..........
Child thread
Child thread
........
     */
}
