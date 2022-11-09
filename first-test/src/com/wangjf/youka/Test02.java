package com.wangjf.youka;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.endsWith("02-29")) {
            System.out.println(-1);
            return;
        }
        int birthYear = Integer.valueOf(str.substring(0, 4));
        int days = 6570;
        for (int i = birthYear; i < birthYear + 18; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                days++;
            }
        }
        System.out.println(days);
    }
}
