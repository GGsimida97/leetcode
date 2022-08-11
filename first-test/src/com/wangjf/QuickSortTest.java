package com.wangjf;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 3};
        new QuickSortTest().quick(0, 4, arr);
//        System.out.println(Arrays.toString(arr));
    }

    int divide(int start, int end, int[] arr) {
        int tag = arr[end];
        int lowIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= tag) {
                int tmp = arr[i];
                arr[i] = arr[lowIndex];
                arr[lowIndex] = tmp;
                lowIndex++;
            }
            System.out.println(Arrays.toString(arr));
        }
        int tmp = arr[end];
        arr[end] = arr[lowIndex];
        arr[lowIndex] = tmp;
//        System.out.println(Arrays.toString(arr));
        return lowIndex;
    }

    void quick(int start, int end, int[] arr) {
        if (start < end) {
            int point = divide(start, end, arr);
            quick(start, point - 1, arr);
            quick(point + 1, end, arr);
        }

    }
}
