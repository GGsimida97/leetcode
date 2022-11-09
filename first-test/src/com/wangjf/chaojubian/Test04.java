package com.wangjf.chaojubian;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Test04 {
    static Deque<Integer> path = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String newStr = s.replaceAll("\\s", "#");
        String[] strs = newStr.split("#");
        int tar = Integer.parseInt(strs[0]);
        int ans = cal(strs, tar);
        System.out.println(ans);

    }

    static int cal(String[] s, int tar) {
        dfs(1, s, tar);
        return count;
    }

    static void dfs(int start, String[] s, int tar) {
        if (tar == 0) {
            count++;
            return;
        }
        for (int i = start; i < s.length; i++) {
            if ("".equals(s[i])) continue;
            int tmp = Integer.parseInt(s[i]);
            if (tar >= tmp) {
                path.addLast(tmp);
                dfs(i, s, tar - tmp);
                path.removeLast();
            }
        }
    }
}