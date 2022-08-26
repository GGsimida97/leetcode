package com.wangjf.microsoft.test818;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        Scanner scanner = new Scanner(System.in);
    }
}

class Solution03 {
    public int solution(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(0, A, B, map)[1];
    }

    public int[] dfs(int start, int[] A, int[] B, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == start && map.get(B[i]) == null) {
                list.add(B[i]);
                map.put(B[i], 1);
            }
            if (B[i] == start && map.get(A[i]) == null) {
                list.add(A[i]);
                map.put(A[i], 1);
            }
        }
        if (list.size() == 0) {
            return new int[]{1, 1};
        }
        int[] ans = new int[2];
        ans[0]++;
        for (Integer next : list) {
            int[] res = dfs(next, A, B, map);
            ans[0] += res[0];
            ans[1] += res[1];
        }
        if (start == 0) {
            return ans;
        }
        ans[1] += ans[0] % 5 > 0 ? ans[0] / 5 + 1 : ans[0] / 5;
        return ans;
    }
}
