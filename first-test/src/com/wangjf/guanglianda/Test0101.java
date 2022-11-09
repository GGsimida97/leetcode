package com.wangjf.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

public class Test0101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        if (arr[0] == 0)
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
