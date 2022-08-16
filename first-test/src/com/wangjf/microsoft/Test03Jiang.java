package com.wangjf.microsoft;


public class Test03Jiang {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int[] A = {4, 2, 5, 4, 3, 5, 1, 4, 2, 7};
        int x = 3, y = 2;
        int solution = solution03.solution(A, x, y);
        System.out.println(solution);
    }
}

class Solution03 {
    public int solution(int[] A, int X, int Y) {
        return dfs(A, X, Y, 0, 1);
    }

    public int dfs(int[] A, int X, int Y, int index, int count) {
        if (index > A.length - 1 && count < X) {
            return Integer.MAX_VALUE;
        }
        if (count == X) {
            return A[index];
        }
        int res = A[index], cost = Integer.MAX_VALUE;
        for (int i = index + Y; i < A.length; i++) {
            cost = Math.min(cost, dfs(A, X, Y, i, count + 1));
        }
        return res + (cost == Integer.MAX_VALUE ? 0 : cost);
    }
}
