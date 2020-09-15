package com.us.lot.extendsthread;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class ThreadOverloading extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("no args method:" + i);
        }
    }
    public void run(int i) {
        for (i = 0; i <= 100; i++) {
            System.out.println("args method:" + i);
        }
    }
}

class DemoThread {
    public static void main(String[] args) {
        ThreadOverloading t = new ThreadOverloading();
        t.start();
    }
}
