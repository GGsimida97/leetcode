
package com.wangjf.youkaniukeceshi;


import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        final int unsortedSubarray = findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println(unsortedSubarray);
    }

    public static String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        String[] strs = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (index == 1) {
                strs[value] = "Gold Medal";
            } else if (index == 2) {
                strs[value] = "Silver Medal";
            } else if (index == 3) {
                strs[value] = "Bronze Medal";
            } else {
                strs[value] = index + "";
            }
            index++;
        }
        return strs;
    }
    public static int findUnsortedSubarray (int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (arr[left] != nums[left] && arr[right] != nums[right]) {
                return right - left + 1;
            }
            if (arr[left] == nums[left]) {
                left++;
            }
            if (arr[right] == nums[right]) {
                right--;
            }
        }
        return 0;
    }
}

