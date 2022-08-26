package com.wangjf.microsoft.test818;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
//        String solution = solution02.solution("39878");
        String solution = solution02.solution("8977");
//        String solution = solution02.solution("12344");
        System.out.println(solution);

    }
}
/***
 *  char a = '0';
 * "0".equals(a)为false
 * Integer.parseInt("090") = 90
 */
class Solution02 {
    List<Integer> resList = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>();

    public String solution(String S) {
        if (S == null || S.length() < 1) return null;
        int size = S.length();
        boolean[] visited = new boolean[size];
        for (int i = 1; i <= size; i++) dfs(S, visited, 0, i);
//        resList.forEach(System.out::println);
        // 此时已经得到所有组合 resList
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer s : resList) {
            if (isValid(s)) priorityQueue.add(s);
        }
        return String.valueOf(priorityQueue.poll());
    }

    boolean isValid(Integer n) {
        if (n == null) return false;
        String s = String.valueOf(n);
//        if ('0' == s.charAt(0)) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    void dfs(String str, boolean[] visited, int times, int number) {
        if (times == number) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) sb.append(s);
            resList.add(Integer.parseInt(sb.toString()));
        }
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.addLast(str.substring(i, i + 1));
            dfs(str, visited, times + 1, number);
            visited[i] = false;
            path.removeLast();
        }
    }
}
// 蒋
//    public String solution(String s) {
//        int[] count = new int[10];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i) - 48]++;
//        }
//        StringBuilder sb = new StringBuilder();
//        int last = -1;
//        for (int i = 9; i >= 0; i--) {
//            if (sb.length() == 0 && i == 0) {
//                continue;
//            }
//            if (last == -1 && (count[i] & 1) == 1) {
//                last = i;
//            }
//            for (int j = 0; j < count[i] / 2; j++) {
//                sb.append(i);
//            }
//        }
//        String s1 = sb.toString();
//        String s2 = sb.reverse().toString();
//        if (last == -1) {
//            if (s1.length() == 0) {
//                return "0";
//            }
//            return s1 + s2;
//        } else {
//            return s1 + last + s2;
//        }
//    }