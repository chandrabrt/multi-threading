package com.us.lot.somemethod;

/**
 * @author chandra khadka
 * @since 2020-09-15
 */
class SlideRotatorSleepExp{

    public static void main(String[] args) throws InterruptedException {
        for (int i=1; i<=10; i++){
            System.out.println("Slide-" +i);
            Thread.sleep(5000);
        }
    }
}
