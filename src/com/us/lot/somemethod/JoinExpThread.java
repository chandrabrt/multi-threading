package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-13
 */
public class JoinExpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++){
            System.out.println("Child thread");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

class TestDemo{
    public static void main(String[] args) throws InterruptedException {
        JoinExpThread t = new JoinExpThread();
        t.start();
        //main thread running
        t.join(10000); //main thread is waiting until child thread is completed

        for (int i = 0; i <=10 ; i++){
            System.out.println("Main thread");
        }
    }

    /*output:
     * Child thread
Child thread
Child thread
Child thread
Child thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Main thread
Child thread
Child thread
Child thread
Child thread
Child thread
Child thread
     */
}
