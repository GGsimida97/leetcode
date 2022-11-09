package com.wangjf.guanglianda;

import java.util.*;

public class Test01 {
    private static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    private static Deque<Integer> path = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        PriorityQueue<Integer> resList = selectNumsFromArrayFocusOrder(arr);
        Integer poll = resList.poll();
        char[] chars = poll.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    static PriorityQueue<Integer> selectNumsFromArrayFocusOrder(int[] nums) {
        if (nums == null || nums.length < 1) return queue;
//        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs2(nums, 0, visited);
        return queue;
    }

    static void dfs2(int[] arr, int times, boolean[] visited) {
        if (path.size() == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer n : path) {
                sb.append(n);
            }
            Integer integer = new Integer(sb.toString());
            queue.offer(integer);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] > arr[i - 1] && !visited[i - 1]) continue;
//            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path.addLast(arr[i]);
            dfs2(arr, times + 1, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}