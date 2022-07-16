package com.wangjf;


import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                Thread sonThread = new Thread(ft, "有返回值的线程");

                System.out.println(sonThread.currentThread().getName()); // main线程
                sonThread.start();

                sonThread.join();

//                sonThread.join();

//                ft.get();
            }
            Thread sonThread2 = new Thread(ft, "第二个有返回值的线程");
            sonThread2.start();
            sonThread2.join();
        }
//        try {
//            System.out.println("子线程的返回值：" + ft.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
