package com.wangjf.tonghuashun.no4117;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        Condition c4 = lock.newCondition();

        new Thread(() -> {
            show("4", c1, c2);
        }).start();
        new Thread(() -> {
            show("3", c2, c3);
        }).start();
        new Thread(() -> {
            show("2", c3, c4);
        }).start();
        new Thread(() -> {
            show("1", c4, c1);
        }).start();

        Thread.sleep(1000);
        lock.lock();
        try {
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

    static void show(String str, Condition cur, Condition next) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                cur.await();
                System.out.print(str);
                next.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
