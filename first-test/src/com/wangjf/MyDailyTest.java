package com.wangjf;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyDailyTest {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<Integer> closestElements = solution.findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3);
//        List<Integer> closestElements = solution.findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4);
        List<Integer> closestElements = solution.findClosestElements(new int[]{3,5,8,10}, 2, 15);
        closestElements.forEach(System.out::println);
    }
}

///**
// * 组合 n个数中选k个做组合
// */
//class TestCombination {
//    List<List<Integer>> resList = new ArrayList<>();
//    Deque<Integer> path = new ArrayDeque<>();
//
//    // 无重复元素
//    public List<List<Integer>> findAll(int[] nums, int k) {
//        if (nums == null || nums.length < 1) return resList;
//        dfs1(0, nums, k);
//        return resList;
//    }
//
//    // 有重复元素
//    public List<List<Integer>> findHasRepeatElement(int[] nums, int k) {
//        if (nums == null || nums.length < 1) return resList;
//        Arrays.sort(nums);
//        dfs2(0, nums, k);
//        return resList;
//    }
//
//    void dfs1(int start, int[] arr, int k) {
//        if (path.size() == k) {
//            resList.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = start; i < arr.length; i++) {
//            path.addLast(arr[i]);
//            dfs1(i + 1, arr, k);
//            path.removeLast();
//        }
//    }
//
//    void dfs2(int start, int[] arr, int k) {
//        if (path.size() == k) {
//            resList.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = start; i < arr.length; i++) {
//            if (i > start && arr[i - 1] == arr[i]) continue;
//            path.addLast(arr[i]);
//            dfs2(i + 1, arr, k);
//            path.removeLast();
//        }
//    }
//}
//
///**
// * 排列 将n个数全排列
// */
//class ArrangementTest {
//    List<List<Integer>> resList = new ArrayList<>();
//    Deque<Integer> path = new ArrayDeque<>();
//
//    // 无重复元素
//    public List<List<Integer>> findAll(int[] nums, int k) {
//        if (nums == null || nums.length < 1) return resList;
//        boolean[] visited = new boolean[nums.length];
//        dfs1(nums, visited, 0, k);
//        return resList;
//    }
//
//    // 有重复元素
//    public List<List<Integer>> findHasRepeatElement(int[] nums, int k) {
//        if (nums == null || nums.length < 1) return resList;
//        boolean[] visited = new boolean[nums.length];
//        Arrays.sort(nums);
//        dfs2(nums, visited, 0, k);
//        return resList;
//    }
//
//    void dfs1(int[] arr, boolean[] visited, int times, int k) {
//        if (times == k) {
//            List<Integer> list = new ArrayList<>(path);
//            resList.add(list);
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            path.addLast(arr[i]);
//            dfs1(arr, visited, times + 1, k);
//            visited[i] = false;
//            path.removeLast();
//        }
//    }
//
//    void dfs2(int[] arr, boolean[] visited, int times, int k) {
//        if (times == k) {
//            List<Integer> list = new ArrayList<>(path);
//            resList.add(list);
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (visited[i]) continue;
//            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
//            visited[i] = true;
//            path.addLast(arr[i]);
//            dfs2(arr, visited, times + 1, k);
//            visited[i] = false;
//            path.removeLast();
//        }
//    }
//}

//class Solution {
//    Set<String> set = new HashSet<>();
//
//    public List<String> letterCasePermutation(String s) {
//        // A~Z : 65 ~ 90
//        // a~z : 97 ~ 122
//        if (s == null || s.length() < 1) return new ArrayList<>();
//        // boolean[] visited = new boolean[s.length()];
//        char[] chars = s.toCharArray();
//        dfs(0, chars);
//        set.add(s);
//        return new ArrayList<>(set);
//    }
//
//    void dfs(int start, char[] cs) {
//        for (int i = start; i < cs.length; i++) {
//            if (Character.isLowerCase(cs[i])) {
//                cs[i] -= 32;
//                dfs(i + 1, cs);
//                cs[i] += 32;
//            }
//            if (Character.isUpperCase(cs[i])) {
//                cs[i] += 32;
//                dfs(i + 1, cs);
//                cs[i] -= 32;
//            }
//        }
//        set.add(new String(cs));
//    }
//}

//class Solution {
//    public int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
//        Arrays.sort(nums);
//        int left = 0, right = 0, res = 1;
//        while (right < nums.length - 1) {
//            if (nums[right] + 1 != nums[right + 1]){
//                left = right + 1;
//            }
//            right++;
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }
//}

//class Solution {
//    public int findMinArrowShots(int[][] points) {
//        if (points == null || points.length < 1) return 0;
//        Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] n1, int[] n2) {
//                Integer i1 = new Integer(n1[1]);
//                Integer i2 = new Integer(n2[1]);
//                return i1.compareTo(i2);
//            }
//        });
//        int count = 1, tar = points[0][1];
//        for (int i = 0; i < points.length; i++) {
//            if (points[i][0] > tar) {
//                count++;
//                tar = points[i][1];
//            }
//        }
//        return count;
//    }
//}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] tmp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        tmp[tmp.length - 1] = x;
        Arrays.sort(tmp);
        List<Integer> res = new ArrayList<>();
        int index = Integer.MIN_VALUE;
        int left = 0, right = tmp.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tmp[mid] == x) {
                index = mid;
                break;
            } else if (x < tmp[mid]) right = mid - 1;
            else left = mid + 1;
        }
        if (index == 0) {
            for (int i = 1; i < tmp.length && i <= k; i++) res.add(tmp[i]);
            return res;
        } else if (index == tmp.length - 1) {
            for (int i = tmp.length - k - 1; i >= 1 && i < tmp.length - 1; i++) res.add(tmp[i]);
            return res;
        }
        int pre = index - 1, last = index + 1, count = 0;
//        SortedSet<Integer> set = new TreeSet<>();
        while (pre >= 0 || last <= tmp.length - 1) {
            if (count == k) break;
            if (pre < 0) {
                for (int j = last; j < tmp.length && j < last + k - count; j++) {
                    res.add(tmp[j]);
                }
                break;
            }
            if (last > tmp.length - 1) {
                for (int i = pre; i >= 0 && i > pre - k + count; i--) {
                    res.add(tmp[i]);
                }
                break;
            }
            if (tmp[index] - tmp[pre] > tmp[last] - tmp[index]) {
                res.add(tmp[last]);
                last++;
            } else if (tmp[index] - tmp[pre] <= tmp[last] - tmp[index]) {
                res.add(tmp[pre]);
                pre--;
            }
            count++;
        }
        Collections.sort(res);
        return res;
    }
}