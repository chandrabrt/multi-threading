package com.us.lot.synchronizeblock;

/**
 * @author chandra khadka
 * @since 2020-09-17
 */
public class DisplayCL {
    ;;;;;;;; ///1 lakh line of code
    public void wish(String name) {
        synchronized (DisplayCL.class){ //class level lock
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

class MyThreadCL extends Thread{
    DisplayCL d;
    String name;

    public MyThreadCL(DisplayCL d, String name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class SynchronizeDemoPO{
    public static void main(String[] args) {
        DisplayCL d1 = new DisplayCL();
        DisplayCL d2 = new DisplayCL();
        MyThreadCL t1 = new MyThreadCL(d1, "Jharana");
        MyThreadCL t2 = new MyThreadCL(d2, "Saleena");
        t1.start();
        t2.start();
    }
}
