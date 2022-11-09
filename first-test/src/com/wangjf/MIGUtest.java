package com.wangjf;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MIGUtest {
    public static void main(String[] args) {
        System.out.println("亨特儿12个月每个月的余额，精确到分");
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[12];
        for (int i = 0; i < 12; i++) {
            arr[i] = scanner.nextDouble();
        }

        double sum = 0;
        for (double d : arr) {
            sum += d;
        }
        DecimalFormat f = new DecimalFormat("#0.0");
        String res = f.format(sum / 12);
        System.out.println("亨特儿12个月的平均账户余额，精确到分" + res);
    }
}
