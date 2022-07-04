package com.wangjf.jz5;


public class Solution {
    public String replaceSpace(String s) {
        //由于String为final类，解题关键是不能在原字符串上修改
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();//线程不安全，StringBuffer线程安全,这边追求速度了
        String[] strs = s.split("");
        for (String n : strs) {
            if (" ".equals(n)) {
                sb.append("%20");
            } else {
                sb.append(n);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a b c";
        String[] strs = str.split("");

        for (String s : strs) {
            System.out.println(s);
        }
    }
}