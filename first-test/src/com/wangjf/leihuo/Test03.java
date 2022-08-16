package com.wangjf.leihuo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = cal(num);
        System.out.println(res);
    }

    static int cal(int n) {
        if (n < 25) return -1;
        int count = 0;
        for (int i = 25; i <= n; i++) {
            String s = String.valueOf(i);
            if (isValid(s)) count++;
        }
        return count;
    }

    static boolean isValid(String str) {
        int size = str.length();
        if (size < 3) return "25".equals(str);
        int left = 0, right = 1;
        boolean flag = false;
        while (right < size) {
            if ("2".equals(String.valueOf(str.charAt(left)))) {
                if ("5".equals(String.valueOf(str.charAt(right)))) flag = true;
                else {
                    left++;
                    right++;
                    continue;
                }
            }
            left++;
            right++;
        }
        return flag;
    }
}
