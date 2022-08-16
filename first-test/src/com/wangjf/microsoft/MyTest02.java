package com.wangjf.microsoft;

import java.util.TreeMap;

public class MyTest02 {
    public int solution(int[] num1, int[] num2) {
        int[] tmp = new int[num1.length];
        TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
        for (int i = 0; i < num1.length; i++) {
            map.put((double) num1[i] / num2[i], i);
        }
        int index = 0;
        for (Double keyDouble : map.descendingKeySet()) {
            tmp[index++] = map.get(keyDouble);
        }
        int l = 0, r = tmp.length - 1, res = 0;
        while (l < r) {
            int flag = compare(num1[l], num2[l], num1[r], num2[r]);
            if (flag > 0) {
                r--;
            } else if (flag < 0) {
                l++;
            } else {
                int tmpl = l;
                while (compare(num1[tmpl], num2[tmpl], num1[r], num2[r]) == 0 && tmpl < r) {
                    res++;
                    tmpl++;
                }
                r--;
            }
        }
        return res;
    }

    public int compare(int x1, int y1, int x2, int y2) {
        if (x1 * y2 + y1 * x2 == y1 * y2) {
            return 0;
        } else if (x1 * y2 + y1 * x2 > y1 * y2) {
            return 1;
        } else {
            return -1;
        }
    }
}
