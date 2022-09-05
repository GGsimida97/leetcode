package com.wangjf.tonghuashun.no7480;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        boolean contain = isContain("adc", "abcd");
        System.out.println(contain);
    }
    public static boolean isContain(String tar, String s) {
        if (tar == null || tar.length() < 1 || s == null || s.length() < 1) return false;
        // 对字符串s进行全排列
        Set<String> set = new HashSet<>();
        Deque<String> path = new ArrayDeque<>();
        Set<String> resSet = helper(s, set, path);
        for (String n : resSet) {
            if (n.contains(tar)) return true;
        }
        return false;

    }

    static Set<String> helper(String s, Set<String> set, Deque<String> path) {
        boolean[] visited = new boolean[s.length()];
        dfs(s, set, path, visited);
        return set;
    }

    static void dfs(String s, Set<String> set, Deque<String> path, boolean[] visited) {
        if (path.size() == s.length()) {
            set.add(String.join("", path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.addLast(s.substring(i, i + 1));
            dfs(s, set, path, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
