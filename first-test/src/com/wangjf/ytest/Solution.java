package com.wangjf.ytest;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int i = 0;
        int res = 0;
        while (i <= 7) {
            res += Math.pow(2, i);
            i += 1;
        }
        System.out.println(res);
    }

    static boolean canDo(int[] arr) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = set.last();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) index = i;
        }
        if (index == 0 || index == arr.length - 1) return false;
        boolean[] resArr = new boolean[arr.length - 1];
        for (int i = 0; i < index; i++) {
            if (arr[i + 1] >= arr[i]) {
                resArr[i] = true;
            }
        }
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i + 1] <= arr[i]) {
                resArr[i] = true;
            }
        }
        for (Boolean n : resArr) {
            if (n == false) return false;
        }
        return true;
    }
}
