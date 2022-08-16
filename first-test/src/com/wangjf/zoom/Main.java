package com.wangjf.zoom;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int nodeNums = Integer.parseInt(scanner.nextLine());
            String[] colorArr = scanner.nextLine().split("");
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < nodeNums; i++) map.put(i + 1, colorArr[i]);
            int res = 1, tmp = 0;
            while (tmp < nodeNums - 1) {
                String[] s = scanner.nextLine().split(" ");
                res += cal(s[0], s[1], map);
                tmp++;
            }
            System.out.println(res);

        }
    }

    static int cal(String s1, String s2, Map<Integer, String> map) {
        String color1 = map.get(Integer.parseInt(s1));
        String color2 = map.get(Integer.parseInt(s2));
        if (color1.equals(color2)) return 2;
        else return 0;
    }
}
