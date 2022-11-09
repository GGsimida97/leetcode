package com.wangjf.binary.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SortTest {
    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 1};
        quickSort(nums, 0 , 3);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 【冒泡排序】
     * 时间复杂度：
     * 最坏：O(n^2)
     * 平均：O(n^2)
     * 最好：O(n)
     *空间复杂度：O(1)
     *
     * 【算法描述】
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * 【稳定性】
     * 在相邻元素相等时，它们并不会交换位置，所以，冒泡排序是稳定排序。
     * 【适用场景】
     * 冒泡排序思路简单，代码也简单，特别适合小数据的排序。但是，由于算法复杂度较高，在数据量大的时候不适合使用。
     */
    public static void BubbleSort(int[] arr) {
        /**
         * 要使算法在最佳情况下有O(n)复杂度，需要做一些改进，增加一个swap的标志，
         * 当前一轮没有进行交换时，说明数组已经有序，没有必要再进行下一轮的循环了，直接退出。
         */
        boolean swap = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }
    /**
     * 【选择排序】
     * 时间复杂度：
     * 最坏：O(n^2)
     * 平均：O(n^2)
     * 最好：O(n^2)
     *空间复杂度：O(1)
     *
     * 【算法描述】
     * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第二步，直到所有元素均排序完毕。
     * 稳定性
     * 用数组实现的选择排序是不稳定的，用链表实现的选择排序是稳定的。
     * 不过，一般提到排序算法时，大家往往会默认是数组实现，所以选择排序是不稳定的。
     *
     * 【适用场景】
     * 选择排序实现也比较简单，并且由于在各种情况下复杂度波动小，因此一般是优于冒泡排序的。
     * 在所有的完全交换排序中，选择排序也是比较不错的一种算法。但是，由于固有的O(n2)复杂度，
     * 选择排序在海量数据面前显得力不从心。因此，它适用于简单数据排序。
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
    /**
     * 【插入排序】
     * 是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *时间复杂度：
     * 最坏：O(n^2)
     * 平均：O(n^2)
     * 最好：O(n)
     *空间复杂度：O(1)
     *【算法描述】
     * 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
     * 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
     * 重复上述过程直到最后一个元素被插入有序子数组中。
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int position = i;
            int value = arr[i];
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
    }

    /**
     * 【快速排序】
     *时间复杂度：
     * 最坏：O(N^2)
     * 平均：O(NlgN)
     * 最好：O(NlgN)
     *空间复杂度：O(n)或O(NlgN)
     * 【稳定性】
     * 快速排序并不是稳定的。这是因为我们无法保证相等的数据按顺序被扫描到和按顺序存放。
     *
     * 【适用场景】
     * 快速排序在大多数情况下都是适用的，尤其在数据量大的时候性能优越性更加明显。但是在必要的时候，需要考虑下优化以提高其在最坏情况下的性能
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int point = divide(arr, start, end);
            quickSort(arr, point + 1, end);
            quickSort(arr, start, point - 1);
        }
    }
    static int divide(int[] arr, int start, int end) {
        int tag = arr[end], lowIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= tag) {
                int tmp = arr[i];
                arr[i] = arr[lowIndex];
                arr[lowIndex] = tmp;
                lowIndex++;
            }
        }
        int tmp = arr[end];
        arr[end] = arr[lowIndex];
        arr[lowIndex] = tmp;
        return lowIndex;
    }
}