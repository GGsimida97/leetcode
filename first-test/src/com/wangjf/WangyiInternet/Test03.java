package com.wangjf.WangyiInternet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//好e 26.32
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("");
        int res = cal(split);
        System.out.println(res);
    }

    static int cal(String[] strs) {
        if (strs == null || strs.length < 3) return 0;
        // reddee
        Map<String, Integer> map = new HashMap<>();
        int r = 0, d = 0, e = 0;
        map.put("r", r);
        map.put("d", d);
        map.put("e", e);
        for (String str : strs) {
            if ("r".equals(str)) map.put("r", ++r);
            else if ("d".equals(str)) map.put("d", ++d);
            else map.put("e", ++e);
        }
        int count = 0;
        int tmp = strs.length / 3;
        int rTmp = Math.abs(tmp - r);
        int eTmp = Math.abs(tmp - e);
        int dTmp = Math.abs(tmp - d);
        count = (rTmp + eTmp + dTmp) / 2;
        return count;

    }
}
