package com.wangjf.permutations;



import java.util.*;

public class MyPractise {
    private static List<List<Integer>> resList = new ArrayList<>();
    private static Deque<Integer> path = new ArrayDeque<>();

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        List<List<Integer>> lists = selectNumsFromArray(arr, 3);
        lists.forEach(System.out::println);


    }

    // n个数中(有重复)选取k个数（组合问题）
    static List<List<Integer>> selectNumsFromArray(int[] nums, int k) {
        if (nums == null || nums.length < 1) return resList;
        Arrays.sort(nums);
        dfs(0, nums, k);
        return resList;
    }

    static void dfs(int start, int[] arr, int k) {
        if (path.size() == k) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            path.addLast(arr[i]);
            dfs(i + 1, arr, k);
            path.removeLast();
        }
    }

    // 从n个数中选取k个数 全排列(排列问题，顺序不同，算不同的情况)
    static List<List<Integer>> selectNumsFromArrayFocusOrder(int[] nums, int k) {
        if (nums == null || nums.length < 1) return resList;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs2(nums, k, 0, visited);
        return resList;
    }

    static void dfs2(int[] arr, int k, int times, boolean[] visited) {
        if (times == k) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path.addLast(arr[i]);
            dfs2(arr, k, times + 1, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
