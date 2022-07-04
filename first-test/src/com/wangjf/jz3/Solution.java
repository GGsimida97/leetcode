package com.wangjf.jz3;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
/*        //暴力破解
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;*/
        //关键在于数组 nums 里的所有数字都在 0～n-1 的范围内
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}