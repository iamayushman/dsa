package com.ayushman.sliding.window;

import com.ayushman.utils.PrintUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Anagram -> shuffled characters
 *   for -> {for, fro, rfo,rof, ofr, orf }
 *
 *  formula
 *
 *      - no item is used more than once
 *      - the order of arrangement matters
 *      total anagram = nPk = n!(n-k)!  (permutation)
 *          if every item is distinct it'd just be n!
 *          anagrams of 'physics' = 8! = 40320
 *
 *
 *      - item is used more than once
 *      - the order or arrangement does not matter
 *       total anagram  = C(n,k) = nCk = n!/((n-k)!k!)
 *          anagrams of 'mississippi' = 8!/(4!4!2!)
 * */
public class AnagramOccurrence {

    public static void main(String[] args) {
        String input = "forxxorfxdofr";

        String pattern = "for";

        int totalAnagramCount = totalAnagramCount(input, pattern);
        System.out.println(MessageFormat.format("Total anagrams for pattern `{0}` in `{1}` is `{2}`", pattern, input, totalAnagramCount));

        int totalAnagramCountSliding = totalAnagramCountSliding(input, pattern);
        System.out.println(MessageFormat.format("Total anagrams for pattern `{0}` in `{1}` is `{2}`", pattern, input, totalAnagramCountSliding));

    }

    private static int totalAnagramCount(String input, String pattern) {
        int n = input.length();

        int count = 0;
        for (int i = 0; i <= n - pattern.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : pattern.toCharArray()) {
                map.put(c, map.getOrDefault(c, 1));
            }
            for (int j = 0; j < pattern.length(); j++) {

                char curr = input.charAt(i + j);
                Integer currentMapValue = map.get(curr);
                if (currentMapValue != null) {
                    int updatedValue = currentMapValue - 1;
                    if (updatedValue == 0) {
                        map.remove(curr);
                    } else {
                        map.put(curr, updatedValue);
                    }
                }
                if (map.isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }


    private static int totalAnagramCountSliding(String input, String pattern) {
        int inputLen = input.length();
        int patLen = pattern.length();
        int[] counter = new int[26];
        Arrays.fill(counter, 0);

        for (int i = 0; i < patLen; i++) {
            counter[pattern.charAt(i) - 'a'] += 1;
        }

        int i = 0, j = 0;
        int count = 0;
        System.out.println(Arrays.toString(counter));
        PrintUtils.divider();

        while (j < inputLen) {
            int index = input.charAt(j) - 'a';
            counter[index] -= 1;
            System.out.println(Arrays.toString(counter));
            if (j - i + 1 == patLen) {
                if (allZeros(counter)) {
                    count++;
                }
                int iIndex = input.charAt(i) - 'a';
                counter[iIndex] += 1;
                System.out.println("index: " + iIndex + "char: " + (char) (iIndex + 'a'));
                i++;
            }
            j++;
        }
        return count;
    }

    private static boolean allZeros(int[] counter) {
        for (int a : counter) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
