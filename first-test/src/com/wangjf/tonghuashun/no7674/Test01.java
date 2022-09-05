package com.wangjf.tonghuashun.no7674;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 0, 0};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int index = 0, i = 0, j;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        j = index;
        for (; j < nums.length; j++) nums[j] = 0;
    }
}
