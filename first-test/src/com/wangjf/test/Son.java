package com.wangjf.test;

public class Son extends Father{

    static {
//        System.out.println("Son类加载了");
        System.out.println(Thread.currentThread() + "ddd");
    }

}


