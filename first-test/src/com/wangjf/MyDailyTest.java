package com.wangjf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class MyDailyTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        String[] strings = solution.permutation(s);
        for (String n : strings) System.out.println(n);
    }
}
class Solution {
    public String[] permutation(String s) {
        HashSet<String> resSet = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] visted = new boolean[arr.length]; // 用以标记已访问的字符
        dfs("", resSet, arr, visted );
        return resSet.toArray(new String[0]);
    }
    void dfs(String resStr, HashSet<String> resSet, char[] arr, boolean[] visted) {
        if (resStr.length() == arr.length) {
            resSet.add(resStr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visted[i]) continue;
            visted[i] = true;
            dfs(resStr + String.valueOf(arr[i]), resSet, arr, visted);
            visted[i] = false;
        }
    }
}
