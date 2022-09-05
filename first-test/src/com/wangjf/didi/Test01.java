package com.wangjf.didi;

import java.util.Arrays;
import java.util.Scanner;

// 45%

/**
 * 5 2
 * 3 10 5 4 2
 * 4
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = cal(arr, k);
        System.out.println(res);
    }

    static int cal(int[] arr, int k) {
        Arrays.sort(arr);
        if (arr.length < 3) {
            double tmp = arr[1] / k;
            if (tmp <= (arr[0] + arr[1]) / 2) {
                return 2;
            } else return 1;
        }
        int res = 1;
        int max = arr[arr.length - 1];
        int index = arr.length - 2, total = max;
        while (index >= 0) {
            double tmp = max / k;
            if (tmp <= (total + arr[index]) / (res + 1)) {
                total += arr[index];
                res++;
            } else {
                max = arr[index];
                total = max;
            }
            index--;
        }
        return res;
    }
}
