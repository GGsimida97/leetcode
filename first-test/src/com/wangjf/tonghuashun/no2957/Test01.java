package com.wangjf.tonghuashun.no2957;

import java.util.Scanner;

//大小写转换
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'a' && chars[i] < 'z') chars[i] -= 32;
            else if (chars[i] > 'A' && chars[i] < 'Z') chars[i] += 32;
        }
        System.out.println(new String(chars));
    }
}
