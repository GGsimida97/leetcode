package com.wangjf.WangyiInternet;

import java.util.Scanner;

//13.33 长城
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] target = new int[2], num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }
        if (length == 1) {
            System.out.println(0);
            return;
        }
        int res = 0;
        target[0] = num[0];
        target[1] = num[1];
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 1) {
                target[1] = Math.max(num[i], target[1]);
            } else {
                target[0] = Math.max(num[i], target[0]);
            }
        }
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 1) {
                res += target[1] - num[i];
            } else {
                res += target[0] - num[i];
            }
        }
        if (target[0] == target[1]) res += length / 2;
        System.out.println(res);
    }
}
