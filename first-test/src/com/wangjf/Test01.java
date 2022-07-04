package com.wangjf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{2,2}};
        System.out.println(Test01.getMinLength(arr));
    }
    public static int getMinLength (int[][] pearls) {
        // write code here
        int row = pearls.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] q : pearls) {
            List<Integer> list = new ArrayList<>();
            for (int[] h : pearls) {
                if (q == h) {
                    continue;
                }
                int d = Math.abs(q[0] - h[0]) + Math.abs(q[1] - h[1]);
                list.add(d);
            }
            lists.add(new ArrayList<>(list));
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> list1 : lists) {
            int sum = 0;
            Collections.sort(list1);
            for (int i = 0; i < 2; i++) {
                sum += list1.get(i);
            }
            min = Math.min(sum, min);
        }
        return min;
    }
}
