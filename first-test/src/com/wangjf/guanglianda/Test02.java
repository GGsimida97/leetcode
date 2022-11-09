package com.wangjf.guanglianda;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        if (n == 1) {
            System.out.println(n % k == 0 ? 1 : 0);
            return;
        }
        int[][] dp = new int[n][10];
        dp[0][(s.charAt(0) - '0') % k]++;
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][cur % k]++;
            for (int j = 0; j < 10; j++) {
                dp[i][(10 * j + cur) % k] += dp[i - 1][j];
            }
        }
        System.out.println(dp[n - 1][0]);
    }
}
