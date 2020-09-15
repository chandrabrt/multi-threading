package com.us.lot.extendsthread;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class OveridingStart extends Thread {

    @Override
    public synchronized void start() {
        System.out.println("start method");
    }

    @Override
    public void run() {
        System.out.println("run method");
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        OveridingStart ot = new OveridingStart();
        ot.start();
        System.out.println("main method");
    }
  /*
     output:
      start method
      main method
   */

}
