package com.wangjf;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 1;

//        while (scanner.hasNextInt()) {
//            int i = scanner.nextInt();
//            System.out.println(i);
//            if (i == 5) break;
//        }

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            System.out.println(Math.max(res, Main.chooseSite(s1)));
        }
    }

    public static int chooseSite(String[] args) {
        if (args.length == 2) return 1;
        List<Integer> indexList = new ArrayList<>();
        int res = 1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) indexList.add(i);
        }
        int tmp = 0;
        for (int i = 0; i < indexList.size() - 1; i++) {
            tmp = Math.max(tmp, (indexList.get(i + 1) - indexList.get(i)));
        }
        int specialRes = Math.max(indexList.get(0), args.length - 1 - indexList.get(indexList.size() - 1));
        res = Math.max(res, specialRes);
        return Math.max(res, tmp / 2);
    }
}