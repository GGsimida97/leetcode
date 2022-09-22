package com.wangjf.boss;

import java.util.Arrays;
import java.util.Scanner;
//
public class Test03 {
    static int[][] f = new int[30][30];
    static int[][] root = new int[30][30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            f[i][i] = scanner.nextInt();
            root[i][i] = i;
        }
        System.out.println(get(1, n));
        dfs(1, n);
    }

    static int get(int l, int r) {
        if (l > r) return 1;
        if (f[l][r] != -1) {
            return f[l][r];
        }
        for (int i = l; i <= r; i++) {
            int now = get(l, i - 1) * get(i + 1, r) + f[i][i];
            if (now > f[l][r]) {
                f[l][r] = now;
                root[l][r] = i;
            }
        }
        return f[l][r];
    }

    static void dfs(int l, int r) {
        if (l > r) return;
        System.out.println(root[l][r]);
        dfs(l, root[l][r] - 1);
        dfs(root[l][r] + 1, r);
    }
}
