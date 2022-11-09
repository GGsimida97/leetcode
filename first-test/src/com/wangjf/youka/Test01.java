package com.wangjf.youka;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int white = 0, black = 0;
        for (int i = 0; i < 2; i++) {
            if (i == 0) white = scanner.nextInt();
            else black = scanner.nextInt();
        }
        int tmp = 0;
        tmp = (black - white) * ((int)Math.sqrt(5) + 1) / 2;
        if (white == tmp) {
            System.out.println("NO");
        } else {
            int x = white - tmp;
            System.out.println("Yes");
            System.out.print(white - x + " ");
            System.out.print(black - x);
        }
    }
}
