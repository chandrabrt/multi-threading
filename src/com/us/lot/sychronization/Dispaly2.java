package com.us.lot.sychronization;

/**
 * @author chandra khadka
 * @since 2020-09-16
 */
public class Dispaly2 {

    public static synchronized void wish(String name){

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

class MyThread2 extends Thread{
    Dispaly2 d;
    String name;

    public MyThread2(Dispaly2 d, String  name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class SynchronizeDemo2 {
    public static void main(String[] args) {
        Dispaly2 d1 = new Dispaly2();
        Dispaly2 d2 = new Dispaly2();
        MyThread2 t = new MyThread2(d1, "chandra");
        MyThread2 t2 = new MyThread2(d2, "hari");
        t.start();
        t2.start();
    }
}