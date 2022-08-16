package com.wangjf.test;

public class Father {
    static {
        System.out.println("father类加载了");
    }

    protected static int a = 1;
}
