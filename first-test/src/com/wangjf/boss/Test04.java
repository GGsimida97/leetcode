package com.wangjf.boss;

import java.util.Arrays;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length == 0) return;
        int[] prices = new int[length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scanner.nextInt();
        }
        int n = prices.length;
        int k = Math.min(2, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        System.out.println(Arrays.stream(sell).max().getAsInt());
    }
}
