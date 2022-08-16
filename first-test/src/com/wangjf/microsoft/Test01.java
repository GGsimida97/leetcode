package com.wangjf.microsoft;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test01 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int[] arr = {5, 19, 8, 1};
        int a = solution01.solution(arr);
        System.out.println(a);
    }
}

class Solution01 {
    public int solution(int[] nums) {
        // 主要为了保证每次poll出队元素 都为最大元素
        // offer入队 只能保证队尾元素一定是最大值
        PriorityQueue<Double> queue = new PriorityQueue<>(new Comparator<Double>() {
            public int compare(Double o1, Double o2) {
                BigDecimal b1 = new BigDecimal(o1);
                BigDecimal b2 = new BigDecimal(o2);
                return b2.compareTo(b1);
            }
        });
        double sum = 0, target = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.offer((double) nums[i]);
        }

        target = sum / 2;
        int res = 0;
        while (compare(sum, target)) {
            double element = queue.poll() / 2;
            sum -= element;
            res++;
            queue.offer(element);
        }
        return res;
    }

    public boolean compare(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.compareTo(b2) > 0;
    }
}
