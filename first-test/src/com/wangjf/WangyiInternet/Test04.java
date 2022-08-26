package com.wangjf.WangyiInternet;

import java.util.*;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = cal(arr);
        System.out.println(res);
    }

    static int cal(int[] nums) {
        Arrangement arrangement = new Arrangement();
        int count = 0;
        List<List<Integer>> list = arrangement.findHasRepeatElement(nums, 3);
        for (List<Integer> path : list) {
            if (isValid(path)) count++;
        }
        return count;
    }

    static boolean isValid(List<Integer> list) {
        if (list.get(0) != list.get(2)) return false;
        else if (list.get(0) <= list.get(1)) return false;
        return true;
    }
}

class Arrangement {
    List<List<Integer>> resList = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    // 有重复元素
    public List<List<Integer>> findHasRepeatElement(int[] nums, int k) {
        if (nums == null || nums.length < 1) return resList;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(nums, visited, 0, k);
        return resList;
    }


    void dfs2(int[] arr, boolean[] visited, int times, int k) {
        if (times == k) {
            List<Integer> list = new ArrayList<>(path);
            resList.add(list);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path.addLast(arr[i]);
            dfs2(arr, visited, times + 1, k);
            visited[i] = false;
            path.removeLast();
        }
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        if (length < 3) {
//            System.out.println(0);
//            return;
//        }
//        int[][] count = new int[length][10];
//        int[] num = new int[length];
//        int first = sc.nextInt();
//        count[0][first] = 1;
//        num[0] = first;
//        for (int i = 1; i < length; i++) {
//            for (int j = 0; j < 10; j++) {
//                count[i][j] = count[i - 1][j];
//            }
//            int element = sc.nextInt();
//            count[i][element]++;
//            num[i] = element;
//        }
//        int res = 0;
//        for (int i = 1; i < num.length; i++) {
//            for (int j = num[i] + 1; j < 10; j++) {
//                res += count[i][j] * (count[length - 1][j] - count[i][j]);
//            }
//        }
//        System.out.println(res);
//    }
//}
