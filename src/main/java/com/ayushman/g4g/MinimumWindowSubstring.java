package com.ayushman.g4g;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {
        int countRequired = t.length();
        int minLen = Integer.MAX_VALUE, i = 0, j = 0, n = s.length(), startIndex = 0;
        if (countRequired > n) {
            return "";
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        while (j < n) {
            char ch = s.charAt(j);
            int fr = freq.getOrDefault(ch, 0);

            if (freq.getOrDefault(ch, 0) > 0) {
                countRequired--;
            }
            freq.put(ch, (fr - 1));

            while (countRequired == 0) {
                // found window size
                //now shrink the window from left
                char start = s.charAt(i);
                int newFr = freq.getOrDefault(start, 0) + 1;
                if (newFr > 0) {
                    countRequired++;
                }

                freq.put(start, newFr);
                int window = j - i + 1;
                if (minLen > window) {
                    minLen = window;
                    startIndex = i;
                }
                i++;
            }

            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
