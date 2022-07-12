package com.wangjf;

import java.util.*;

public class MyDailyTest {
    static int i = 2;
    static int gg = 0;
    public static void main(String[] args) throws Exception {

        Number n = 2.3;
        Class<? extends Number> c = n.getClass();
        System.out.println(c);
//        int j = 1;
//        A threadA = new A(i,j);
//        B threadB = new B(i,j);
//        threadA.start();
//        threadB.start();
//        threadA.join();
//        threadB.join();

    }
}
class A extends Thread {
    private int a;
    private int b;
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            MyDailyTest.gg += 1;
            this.a += 1;
            System.out.println("线程A" + MyDailyTest.gg);
        }
    }

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class B extends Thread {
    private int a;
    private int b;
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            MyDailyTest.gg += 1;
            this.a += 1;
            System.out.println("线程B" + MyDailyTest.gg);
        }
    }

    public B(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
