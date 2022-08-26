package com.wangjf.WangyiInternet;

import java.util.Scanner;
//13.33
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = cal(arr[0], arr[1]);
        System.out.println(res);
    }

    static int cal(int i, int j) {
        if (i % j == 0 || j % i == 0) return 0;
        return -1;
    }
}
