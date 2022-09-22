package com.wangjf.boss;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = change(s);
        System.out.println(res);
    }

    static int change(String n) {
        if (n.length() < 2) return 0;
        if ((n.contains("2") && n.contains("5")) || (n.contains("4") && n.contains("5"))) {
            return 2;
        }
        char[] chars = n.toCharArray();
        int times = 1;
        while (true) {
            int res = cal(chars);
            if (res >= 10) {
                times++;
                chars = (res + "").toCharArray();
            } else {
                return times;
            }
        }
    }

    static int cal(char[] arr) {
        int sum = Integer.valueOf(arr[0]) - 48;
        for (int i = 1; i < arr.length; i++) {
            int next = Integer.valueOf(arr[i]) - 48;
            sum *= next;
        }
        return sum;
    }
}
