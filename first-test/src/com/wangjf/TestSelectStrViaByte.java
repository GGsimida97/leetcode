package com.wangjf;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class TestSelectStrViaByte {
    public static void main(String[] args) throws Exception {
        System.out.println(TestSelectStrViaByte.selectStrViaByte("WC中国人f", 5));
    }
    static String selectStrViaByte(String s, int n) throws UnsupportedEncodingException {
        if (s == null || s.length() < 1) return null;
//        if (s.getBytes("GBK").length <= n) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (n == 0 || n == -1) break;
            if ((s.charAt(i) + "").getBytes("GBK").length < 2) {
                sb.append(s.charAt(i));
                n--;
            } else {
                sb.append(s.charAt(i));
                n -= 2;
            }
        }
        return sb.toString();
    }
}
