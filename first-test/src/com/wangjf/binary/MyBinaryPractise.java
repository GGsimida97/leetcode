package com.wangjf.binary;

import java.util.Arrays;
import java.util.Collections;

/**
 * 8.26有序数组二分系列复习
 */
public class MyBinaryPractise {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 6, 6};
        System.out.println(searchRight(arr, 6));
    }

    // 二分查找（左右闭区间）返回目标值索引
    static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    //重复元素  查找目标值左边界
    static int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (target > mid) left = mid + 1;
            else right = mid - 1;
        }
        //出循环 left = [0, nums.length] 理解为比target小的元素个数
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    // 搜索右边界
    static int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 缩小左边界以固定右边界
                left = mid + 1; // [mid + 1， right]
            } else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        // 出循环 left = [0, nums.length]
        // 而 mid = left - 1
        if (left == 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}

