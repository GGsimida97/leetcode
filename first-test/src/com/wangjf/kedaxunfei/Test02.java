package com.wangjf.kedaxunfei;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int size = scanner.nextInt();
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] newArr = merge(arr);
        if (newArr.length > 1) {
            System.out.println("fail");
        } else {
            int res = cal(arr);
            System.out.println(res);
        }

    }

    static int cal(int[][] arr) {
        if (arr == null || arr.length < 1) return 0;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                Integer i1 = new Integer(n1[1]);
                Integer i2 = new Integer(n2[1]);
                return i1.compareTo(i2);
            }
        });
        int count = 1, tar = arr[0][1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= tar) {
                count++;
                tar = arr[i][1];
            }
        }
        return count;
    }

    static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return new int[0][0];
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] resArr = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || resArr[index][1] < interval[0]) resArr[++index] = interval.clone();
            else resArr[index][1] = Math.max(resArr[index][1], interval[1]);
        }
        return Arrays.copyOf(resArr, index + 1);
    }
}
