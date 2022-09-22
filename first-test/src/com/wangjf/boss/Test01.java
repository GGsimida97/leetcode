package com.wangjf.boss;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = scanner.nextInt();
        int two = scanner.nextInt();
        int res = cal(one, two);
        System.out.println(res);
    }

    static int cal(int i, int j) {
        if (i == j) return i;
        int big, small;
        if (i > j) {
             big = i;
             small = j;
        } else {
             big = j;
             small = i;
        }
        int index = 2;
        while (true) {
            int tmp = small * index;
            if ((tmp % big) == 0) {
                return tmp;
            }
            index++;
        }
    }
}
