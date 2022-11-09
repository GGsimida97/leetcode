package com.wangjf.chaojubian;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
//        int[][] task = {{300, 20}, {500, 30}, {620, 50}, {370, 30}, {400, 50}, {450, 30}, {380, 40}, {150, 10}};
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer task1, Integer task2) {
//                return -new BigDecimal(task[task1][0] / task[task1][1]).
//                        compareTo(new BigDecimal(task[task2][0] / task[task2][1]));
//            }
//        });
//        for (int i = 0; i < 8; i++) {
//            queue.add(i);
//        }
//        Scanner scanner = new Scanner(System.in);
//        int fileNums = scanner.nextInt();
//        int ans = 0;
//        for (Integer n : queue) {
//            if (fileNums >= task[n][1]) {
//                ans += task[n][0];
//                fileNums -= task[n][1];
//            }
//        }
//        System.out.println(ans);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), ans = 0;
        if (num < 10) ans = 0;
        else if (num < 20) ans = 150;
        else if (num < 30) ans = 300;
        else if (num < 40) ans = 500;
        else if (num < 50) ans = 500;
        else if (num < 60) ans = 800;
        else if (num < 70) ans = 950;
        else if (num < 80) ans = 1100;
        else if (num < 90) ans = 1250;
        System.out.println(ans);
    }
}
