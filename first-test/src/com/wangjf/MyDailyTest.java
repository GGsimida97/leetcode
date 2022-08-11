package com.wangjf;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyDailyTest {


    public static void main(String[] args) {
        String[] str = new String[3];
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextLine()) {
            str[0] = scanner.nextLine();
//            System.out.println(str[0]);
            str[1] = scanner.nextLine();
//            System.out.println(str[1]);
            str[2] = scanner.nextLine();
            int cal = MyDailyTest.cal(str[1], str[2]);
            System.out.println(cal);
        }

//        String s = "<div>ddd</div>";
//        Pattern pattern = Pattern.compile("(<div>)|(</div>)");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            String substring = s.substring(matcher.start(), matcher.end());
//            System.out.println(substring);
//        }

//        System.out.println(matcher.group());
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(1));
//        }

    }


    public static int cal(String s1, String s2) {
        if (s2.equals("00:00")) s2 = "24:60";
        String[] strs1 = s1.split(":");
        String[] strs2 = s2.split(":");
        int sum1 = Integer.valueOf(strs1[0]) * 60 + Integer.valueOf(strs1[1]);
        int sum2 = Integer.valueOf(strs2[0]) * 60 + Integer.valueOf(strs2[1]);
        if (s2.equals("24:60")) return sum2 - sum1 - 60;
        return sum1 - sum2;
    }
}
