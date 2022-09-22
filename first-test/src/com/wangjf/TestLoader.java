package com.wangjf;

public class TestLoader {
    public static void main(String[] args) {
        new Aaa();
    }
}
class Aaa {
    String s = "dd";
    int alen = 1;

    public Aaa() {
        System.out.println("dddd");
//        this.s = "d";
    }
}
