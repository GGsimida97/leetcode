package com.wangjf.reflection;

public class TestObject {
    private int age;
    public String name;

    private TestObject(String name) {
        this.name = name;
    }

    public TestObject(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private String one(String msg) {
        System.out.println("age:" + this.age + "name:" + this.name);
        return "one方法执行";
    }
}
