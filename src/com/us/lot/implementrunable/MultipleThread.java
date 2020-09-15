package com.us.lot.implementrunable;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class MultipleThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Child");
    }
}

class Dem{

    public static void main(String[] args) {
        MultipleThread  m = new MultipleThread();
        Thread t = new Thread(m);
//        t.start();
        m.run();
        System.out.println("Main");
    }
}
