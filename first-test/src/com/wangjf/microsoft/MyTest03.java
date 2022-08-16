package com.wangjf.microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MyTest03 {
    public static void main(String[] args) {
//        int[] A = {4, 2, 5, 4, 3, 5, 1, 4, 2, 7};
//        int x = 3, y = 2;
        int[] A = {4, 2, 3, 7};
        int x = 2, y = 2;
        Solution solution = new Solution();
        int solution1 = solution.solution(A, x, y);
        System.out.println(solution1);
    }
}

class Solution {
    List<List<Integer>> allList = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public int solution(int[] A, int X, int Y) {
        // x表示x个疗程；y表示两个疗程的间隔天数
        // 将x看成是组合的次数
        if (A == null || A.length < 1) return -1;
        dfs(A, 0, X, Y);
        // 此时已经得到所有个数为x，间隔为y的组合集allList
        if (allList.isEmpty()) return -1;
        int res = Integer.MAX_VALUE;
        for (List<Integer> list : allList) {
            int sum = list.stream().mapToInt(x -> x).sum();
            res = Math.min(res, sum);
        }
        return res;
    }

    void dfs(int[] arr, int start, int x, int y) {
        if (path.size() == x) {
            allList.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i += y) {
            path.addLast(arr[i]);
            dfs(arr, i + y, x, y);
            path.removeLast();
        }
    }
}
