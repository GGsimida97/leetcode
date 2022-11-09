package com.wangjf.chaojubian;

import java.util.*;

public class Test03 {
    static Deque<Integer> path = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tar = scanner.nextInt();
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numsList.add(scanner.nextInt());
        }
        int ans = cal(numsList, tar);
        System.out.println(ans);
    }

    static int cal(List<Integer> list, int tar) {
        dfs(0, list, tar);
        return count;
    }

    static void dfs(int start, List<Integer> list, int tar) {
        if (tar == 0) {
            count++;
            return;
        }
        for (int i = start; i < list.size(); i++) {
            int tmp = list.get(i);
            if (tar >= tmp) {
                path.addLast(tmp);
                dfs(i, list, tar - tmp);
                path.removeLast();
            }
        }
    }
}
