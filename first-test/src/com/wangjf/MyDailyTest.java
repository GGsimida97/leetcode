package com.wangjf;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyDailyTest {

    public static void main(String[] args) throws InterruptedException {

//        Scanner scanner = new Scanner(System.in);
//        int mount = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] arr = new int[mount];
//        for (int i = 0; i < mount; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int res = cal(arr, k);
//        System.out.println(res);
//    }
//
//    public static int cal(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                int extra = nums[j] > nums[i] ? nums[j] - nums[i] : 0;
//                dp[j] = Math.min(dp[j], dp[i] + extra);
//            }
//        }
//
//
        int[] arr = {9,10,9,-7,-4,-8,2,-6};
        Solution s = new Solution();
        int[] ints = s.maxSlidingWindow(arr, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
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

//// 139单词拆分
//class Solution {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s == null) return false;
//        return dfs(s, wordDict, 0);
//    }
//    boolean dfs(String s, List<String> wordDict, int start) {
//        if (s.length() == 0) {
//            return true;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (start + i == s.length()) break;
//            if (!wordDict.contains(s.substring(start, start + i + 1))) continue;
//            return dfs(s.substring(start + i + 1), wordDict, 0);
//        }
//        return false;
//    }
//}

////148 排序链表
//
//
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//
//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
//}
//class Solution {
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            public int compare(ListNode l1, ListNode l2) {
//                Integer i = new Integer(l1.val);
//                Integer j = new Integer(l2.val);
//                return i.compareTo(j);
//            }
//        });
//        ListNode cur = head;
//        while (cur != null) {
//            queue.offer(cur);
//            cur = cur.next;
//        }
//        ListNode root = new ListNode(0);
//        while (!queue.isEmpty()) {
//            ListNode poll = queue.poll();
//            System.out.println(poll);
//            root.next = new ListNode(poll.val);
//
//            root = root.next;
//        }
//        return root.next;
//    }
//}

//// 选择两个正序数组的中位数
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length, len2 = nums2.length;
//        int[] arr = new int[len1 + len2];
//        int i = 0, j = 0, index = 0;
//        while (i < len1 && j < len2) {
//            if (nums1[i] < nums2[j]) {
//                arr[index] = nums1[i];
//                i++;
//            } else {
//                arr[index] = nums2[j];
//                j++;
//            }
//            index++;
//        }
//        if (i == len1 && j == len2) return cal(arr);
//        if (i == len1) {
//            copy(arr, index, nums2, j);
//        } else copy(arr, index, nums1, i);
//        return cal(arr);
//    }
//    void copy(int[] arr, int index, int[] nu, int t) {
//        for (int i = index; i < arr.length && t < nu.length; i++) {
//            arr[i] = nu[t];
//            t++;
//        }
//    }
//    double cal(int[] arr) {
//        int size = arr.length;
//        if ((size & 1) == 1) {
//            return (double) arr[size / 2];
//        } else return ((double) arr[size / 2] + (double) (arr[size / 2 - 1])) / 2;
//    }
//}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for (int j = i; j < i + k && j < nums.length; j++) {
                // PriorityQueue<Integer> tmp = queue;
                queue.offer(nums[j]);
            }
            list.add(queue.poll());
        }
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}