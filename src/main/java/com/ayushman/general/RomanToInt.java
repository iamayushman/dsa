package com.ayushman.general;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    private static final Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        System.out.println(MessageFormat.format("{0} -> {1}", s1, romanToInt(s1)));
        System.out.println(MessageFormat.format("{0} -> {1}", s2, romanToInt(s2)));
        System.out.println(MessageFormat.format("{0} -> {1}", s3, romanToInt(s3)));
    }

    public static int romanToInt(String s) {
        int n = s.length();
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                char curr = s.charAt(i);
                char prev = s.charAt(i - 1);
                if ((prev == 'I' && (curr == 'V' || curr == 'X')) || (prev == 'X' && (curr == 'L' || curr == 'C')) || (prev == 'C' && (curr == 'D' || curr == 'M'))) {
                    num += (map.get(curr) - map.get(prev));
                    i--;
                    continue;
                }
            }
            num += map.get(s.charAt(i));
        }
        return num;
    }
}
