package com.wangjf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonDoubleChecker {
    private volatile static SingletonDoubleChecker single;

    public static SingletonDoubleChecker getInstance() {
        if (null == single) {
            synchronized (SingletonDoubleChecker.class) {
                if (null == single) {
                    single = new SingletonDoubleChecker();
                }
            }
        }
        return single;
    }

    private SingletonDoubleChecker() {
    }

}

class Test009 {
    public static void main(String[] args) throws InterruptedException {


        Map<SingletonDoubleChecker, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
//                String name = Thread.currentThread().getName();
//                SingletonDoubleChecker instance = SingletonDoubleChecker.getInstance();
                    map.put(SingletonDoubleChecker.getInstance(), Thread.currentThread().getName());

            }).start();
        }
        Thread.sleep(1000);
        System.out.println(map.size());
    }
}