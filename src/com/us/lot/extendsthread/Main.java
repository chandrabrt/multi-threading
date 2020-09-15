package com.us.lot.extendsthread;

/**
 * @author chandra khadka
 * @since 2020-09-12
 */
public class Main {

    public static void main(String[] args) {
        /*
          In Main Thread there is only one thread and is responsible to start() other thread. Here,
          Child thread(MyThread class) is responsible to start run() method and Main Thread is responsible to
          run this main() method code.
         */
        MyThread myThread = new MyThread(); //Thread instantiation

        myThread.start(); //starting of thread

        for (int i=0; i<100; i++){
            System.out.println("Main Thread: "+ i);
        }
    }
}
