package com.wangjf;


import java.util.*;
import java.util.regex.Matcher;


public class Test002 {

    public static void main(String[] args) {

        // n表示层数
        // m表示颜色数
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int res = Test002.cal(arr);
            System.out.println(res);
        }
    }

    static int cal(int[][] arr) {
        int row = arr.length;
        int i = 0, res = 0;
        while (i < row - 1) {
            if (!Test002.exists(arr[i], arr[i + 1])) {
                int a1 = Arrays.stream(arr[i]).min().getAsInt();
                int a2 = Arrays.stream(arr[i + 1]).min().getAsInt();
                res += a1 * a2;
            }
            i++;
        }
        return res;
    }

    static boolean exists(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < 2; i++) {
            if (arr1[i] == arr2[i]) return true;
        }
        return false;
    }
}

//class Solution {
//    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length < 1) return new int[0][0];
//        if (intervals.length < 2) return intervals;
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
//        int[][] resArr = new int[intervals.length][2];
//        int index = 0;
//        for (int[] interval : intervals) {
//            if (index == 0 || resArr[index - 1][1] < interval[0]) resArr[index++] = interval;
//            else resArr[index - 1][1] = Math.max(resArr[index - 1][1], interval[1]);
//        }
//        return Arrays.copyOf(resArr, index);
//    }
//}
class Solution {
    public void sortColors(int[] nums) {
        // 定义两个指针 zeroPoint负责将0分配到数组头，twoPoint负责将2分配到数组尾
        // i用于顺序遍历数组
        if (nums == null || nums.length < 3) return;
        int i = 0, zeroPoint = 0, twoPoint = nums.length;
        while (i < twoPoint) {
            if (nums[i] == 0) {
                swap(i, zeroPoint, nums);
                i++;
                zeroPoint++;
            } else if (nums[i] == 2) {
                twoPoint--;
                swap(i, twoPoint, nums);
            } else i++;
        }
    }

    void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}