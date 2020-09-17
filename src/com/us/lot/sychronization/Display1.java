package com.us.lot.sychronization;

/**
 * @author chandra khadka
 * @since 2020-09-16
 */
public class Display1 {
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

class MyThread1 extends Thread{
    Display1 d;
    String name;

    public MyThread1(Display1 d, String  name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class SynchronizeDemo1{
    public static void main(String[] args) {
        Display1 d1 = new Display1();
        Display1 d2 = new Display1();
        MyThread1 t = new MyThread1(d1, "chandra");
        MyThread1 t2 = new MyThread1(d2, "hari");
        t.start();
        t2.start();
    }
    //output: irregular output. in this case synchronization not required because two threads(t1,t2) pointing two different objects d1 and d2
    //better to remove synchronization in this type of situation.
}