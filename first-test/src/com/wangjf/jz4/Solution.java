package com.wangjf.jz4;

/**
 * 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
/*        //暴力破解
        for (int[] arr : matrix) {
            for (int num : arr) {
                if (num == target) {
                    return true;
                }
            }
        }
        return false;*/
        /**
         * 正解：站在右上角看，其实是一个平衡二叉树
         *          * [
         *          *   [1,   4,  7, 11, 15],
         *          *   [2,   5,  8, 12, 19],
         *          *   [3,   6,  9, 16, 22],
         *          *   [10, 13, 14, 17, 24],
         *          *   [18, 21, 23, 26, 30]
         *          * ]
         *          * 注：什么是二叉查找树与平衡二叉树
         *          * https://blog.csdn.net/qq_25940921/article/details/82183093
         */

        //上来先判定非空因为matrix[0]可能为0，那么取m是会存在空指针异常
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;//行row
        int m = matrix[0].length;//列col

        //从右上角开始查找
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (target > matrix[row][col]) {
                //往右子树找（列不变，行+1）
                row++;
            } else if (target < matrix[row][col]) {
                //往左子树找(行不变,列-1)
                col--;
            } else return true;
        }
        //找到数组下标越界还是没找到
        return false;
    }

    public static void main(String[] args) {
        String s = "2 wo l";
        String[] split = s.split("");
        //System.out.println(split.length);
        for (String n : split) {
            System.out.println(n);
        }
    }
}
