package com.wangjf;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyDailyTest {


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] arr = {{0,1,2,3,4},{24,23,22,21,5}, {12,13,14,15,16}, {11,17,18,19,20}, {10,9,8,7,6}};
//        int[][] arr = {{0,1,2,3},{24,23,22,21}};
//        int i = solution.swimInWater(arr);
//        System.out.println(i);
        int[][] arr = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               Integer i1 = new Integer(o1[1]);
               Integer i2 = new Integer(o2[1]);
               return i1.compareTo(i2);
            }
        });
//        Arrays.sort(arr, (v1, v2) -> v1[1] - v2[1]);
        for (int[] n : arr) {
            for (int i : n) System.out.println(i);
        }
    }
}

class Solution {
    List<List<Integer>> resList = new ArrayList<>();

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length < 1) return -1;
        // 重写compare方法 使得每次poll出队都是最大元素，也就是队尾一直是最大元素
        PriorityQueue<Integer> path = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        int row = grid.length, col = grid[0].length;
        int target = grid[row - 1][col - 1];
        boolean[][] visited = new boolean[row][col];
        dfs(0, 0, grid, target, visited, path);
        int res = Integer.MAX_VALUE;
        for (List<Integer> queue : resList) {
            res = Math.min(res, queue.get(0));
        }
        return res;
    }

    void dfs(int i, int j, int[][] arr, int tar, boolean[][] visited, PriorityQueue<Integer> path) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j]) return;
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            path.offer(arr[i][j]);
            resList.add(new ArrayList<>(path));
            return;
        }
        visited[i][j] = true;
        path.offer(arr[i][j]);
        dfs(i + 1, j, arr, tar, visited, path);
        dfs(i - 1, j, arr, tar, visited, path);
        dfs(i, j + 1, arr, tar, visited, path);
        dfs(i, j - 1, arr, tar, visited, path);
        visited[i][j] = false;
        path.poll();
    }
}
