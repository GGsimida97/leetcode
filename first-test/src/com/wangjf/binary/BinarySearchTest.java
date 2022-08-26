package com.wangjf.binary;

/**
 * 给定非降序数组nums与目标值target
 * 这边统一为左右都为闭的搜索
 * 即left = 0, right = nums.length - 1
 * while (left <= right)
 * 因此更新【搜素区间】为
 * left = mid + 1 ==> [mid + 1, right]
 * right = mid - 1 ==> [left, mid - 1]
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 4};
        System.out.println(binarySearchRight(arr, 2));

    }

    // 普通二分查找
    static int binarySearchTar(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止(left + right) / 2 int越界
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearchLeft(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        /**
         * 这个while循环得到结果：小于target的元素数量
         * 即出循环 left = [0, nums.length]
         * 注：出循环 left = right + 1
         *    而 right = mid - 1
         *    因此 left = mid
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 不直接返回，缩小右边界以固定左边界 ==> [left, mid - 1]
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }
    static int binarySearchRight(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        /**
         * 因为我们对 left 的更新必须是 left = mid + 1，
         * 就是说 while 循环结束时，nums[left] 一定不等于 target 了，而 nums[left-1] 可能是 target。
         *
         * 注：出循环 left = right + 1
         *    而 left = mid + 1
         *    因此 mid = left - 1
         */
        if (left == 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
