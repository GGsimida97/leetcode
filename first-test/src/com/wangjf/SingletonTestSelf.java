package com.wangjf;

public class SingletonTestSelf {
    public static void main(String[] args) {
        A instance = A.getInstance();
    }
}

class A {
    private static final A INSTANCE = new A();
    private A () {}
    static A getInstance() {
        return INSTANCE;
    }
}

