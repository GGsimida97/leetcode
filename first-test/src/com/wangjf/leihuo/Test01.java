package com.wangjf.leihuo;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

public class Test01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String newStr = s.replaceAll("\\[", "");
//        System.out.println(newStr);
        String[] split = newStr.split("],");
        boolean[] visited = new boolean[split.length];
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            String[] eachArr = split[i].split(",");
            dfs(i, visited, count, split, eachArr);
        }
        if (count == split.length) System.out.println("true");
        else System.out.println("false");
    }

    static void dfs(int startIndex, boolean[] visited, int count, String[] split, String[] eachArr) {
        if (startIndex == split.length) return;
        visited[startIndex] = true;
        count++;


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