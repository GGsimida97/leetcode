package com.wangjf.chaojubian;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int[][] arr = new int[row][10];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(cal(arr[i]));
        }
    }

    static int cal(int[] arr) {
        int count = 0, need = 2;
        for (int i = 9; i >= 0; i++) {
            count += need / 2;
            if (arr[i] >= need) {
                return count;
            }
            need = 2 * (need - arr[i]);
        }
        return -1;
    }
}
