package com.us.lot.sychronization;

/**
 * @author chandra khadka
 * @since 2020-09-15
 */
public class Display {

    public synchronized void wish(String name){
        for (int i=1; i<=5; i++){
            System.out.println("Good morning!!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

class MyThread extends Thread{
        Display d;
        String name;

        public MyThread(Display d, String  name){
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
        MyThread t = new MyThread(d, "chandra");
        MyThread t2 = new MyThread(d, "hari");
        MyThread t3 = new MyThread(d, "john");
        MyThread t4 = new MyThread(d, "dhoni");
        t.start();
        t2.start();
        t3.start();
        t4.start();
    }

//    output: regular output
}