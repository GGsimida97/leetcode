package com.wangjf;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Test005 {

    public static void main(String[] args) {
        float a = 0.125f;
        double b = 0.125;
        System.out.println((a -b) == 0.0);
        Scanner s = new Scanner(System.in);
        int tar = s.nextInt();

        int[][] resArr = findContinuousSequence(tar);
        System.out.print("[");
        for (int i = 0; i < resArr.length; i++) {
            if (i < resArr.length - 1) {
                System.out.print(Arrays.toString(resArr[i]) + ",");
            } else {
                System.out.print(Arrays.toString(resArr[i]));
            }
        }
        System.out.print("]");
    }

    public static int[][] findContinuousSequence(int target) {

        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
