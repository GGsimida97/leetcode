package com.wangjf.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//64
public class Test02 {
    public static int max, target, left, right;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrNum = scanner.nextInt();
        if (arrNum == 0) return;
        int[][] arr = new int[arrNum][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrNum; j++) {
                arr[j][i] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arrNum; i++) {
            left = arr[i][0];
            right = arr[i][1];
            target = arr[i][2];
            max = Math.max(("" + left).length(), ("" + right).length());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                search(1, j, j, set);
            }
            System.out.print(set.size() + " ");
        }
    }

    static void search(int length, int sum, int num, Set<Integer> set) {
        if (sum == target && num <= right && num >= left) set.add(num);
        if (length == max) return;
        for (int i = 0; i < 10; i++) {
            int nextSum = num == 0 ?  i : sum ^ i;
            search(length + 1, nextSum, 10 * num + i, set);
        }
    }
}
