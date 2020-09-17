package com.us.lot.sychronization;

/**
 * @author chandra khadka
 * @since 2020-09-16
 */
public class Displays {

    public synchronized void displayn(){
        for (int i=1; i<=10; i++){
            System.out.println(i);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public synchronized void displayc(){
        for (int i=65; i<=75; i++){
            System.out.println((char) i);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}

class MyThreads extends Thread{
    Displays d;

    public MyThreads(Displays d){
        this.d = d;
    }

    @Override
    public void run() {
        d.displayn();
    }
}

class MyThreads1 extends Thread{
    Displays d;

    public MyThreads1(Displays d){
        this.d = d;
    }

    @Override
    public void run() {
        d.displayc();
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        Displays d = new Displays();

        MyThreads t1 = new MyThreads(d);
        MyThreads1 t2 = new MyThreads1(d);
        t1.start();
        t2.start();
    }
}