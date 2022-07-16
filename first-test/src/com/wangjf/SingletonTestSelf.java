package com.wangjf;

public class SingletonTestSelf {
    public static void main(String[] args) {
        A instance = A.getInstance();
        System.out.println(instance.doSome());

    }
}

class A {
    private static A a;
    private String name;

    static {
        System.out.println("实例化一个单例A");
        a = new A();
    }

    private A() {
        System.out.println("A构造方法");
    }

    static A getInstance() {
        return a;
    }
    String doSome(){
        return "A对象方法";
    }
}