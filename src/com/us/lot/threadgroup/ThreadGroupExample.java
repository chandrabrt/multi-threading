package com.us.lot.threadgroup;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup g = new ThreadGroup("first group");
        System.out.println(g.getParent().getName());

        ThreadGroup g1 = new ThreadGroup(g, "second thread");
        System.out.println(g1.getParent().getName());
    }
}
