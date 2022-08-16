package com.wangjf.leihuo;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.List;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String newStr = s.replaceAll("\\[", "");
//        System.out.println(newStr);
        String[] split = newStr.split("],");
        boolean[] visited = new boolean[split.length];
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            String[] eachArr = split[i].split(",");
            dfs(i, visited, count, split, eachArr);
        }
        if (count == split.length) System.out.println("true");
        else System.out.println("false");
    }

    static void dfs(int startIndex, boolean[] visited, int count, String[] split, String[] eachArr) {
        if (startIndex == split.length) return;
        visited[startIndex] = true;
        count++;


    }
}
