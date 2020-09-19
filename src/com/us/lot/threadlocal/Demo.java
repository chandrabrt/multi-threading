package com.us.lot.threadlocal;

/**
 * @author chandra khadka
 * @since 2020-09-19
 */
public class Demo {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal() {
            @Override
            public Object initialValue() {
                return "abc";
            }
        };
        System.out.println(tl.get());//null
        tl.set("chandra");
        System.out.println(tl.get());//chandra
        tl.remove();
        System.out.println(tl.get());//null
    }
}
