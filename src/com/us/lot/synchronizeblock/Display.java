package com.us.lot.synchronizeblock;

/**
 * @author chandra khadka
 * @since 2020-09-17
 */
public class Display {
    ;;;;;;;; ///1 lakh line of code
    public void wish(String name) {
        synchronized (Display.class){ //lock on current object
            for(int i=1; i<=10; i++){
                System.out.println("Good morning");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
    ;;;;;;;; ///1 lakh line of code
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

class SynchronizeDemo{
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Jharana");
        MyThread t2 = new MyThread(d, "Saleena");
        t1.start();
        t2.start();
    }
}
