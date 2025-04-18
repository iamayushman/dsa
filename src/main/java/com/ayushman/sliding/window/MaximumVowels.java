package com.ayushman.sliding.window;

import com.ayushman.utils.PrintUtils;

import java.util.function.Predicate;

/*
 * Given a string s and an integer k,
 * return the maximum number of vowel letters in any substring of s with length k.
 * */
public class MaximumVowels {

  public static Predicate<Character> isVowel =
      a ->
          a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'i' || a == 'I' || a == 'o'
              || a == 'O' || a == 'u' || a == 'U';

  public static void main(String[] args) {
    System.out.println(maxVowels("abciiidef", 3));
    System.out.println(maxVowels("aeiou", 2));
    System.out.println(maxVowels("leetcode", 3));
    System.out.println(maxVowels("weallloveyou", 7));
    System.out.println(maxVowels("weallloveyou", 7));
    PrintUtils.divider("Sliding window");
    System.out.println(maxVowelsSW("abciiidef", 3));
    System.out.println(maxVowelsSW("aeiou", 2));
    System.out.println(maxVowelsSW("leetcode", 3));
    System.out.println(maxVowelsSW("weallloveyou", 7));
    System.out.println(maxVowelsSW("weallloveyou", 7));
  }

  /* Bruit force
   * O(n^2)
   * */
  public static int maxVowels(String str, int k) {
    int maxV = 0;
    int n = str.length();
    for (int i = 0; i <= n - k; i++) {
      int count = 0;
      for (int j = 0; j < k; j++) {
        if (isVowel.test(str.charAt(i + j))) {
          count++;
        }
      }
      maxV = Math.max(count, maxV);
    }
    return maxV;
  }

  public static int maxVowelsSW(String s, int k) {
    int maxV = 0, count = 0, i = 0, j = 0, n = s.length();
    while (j < n) {
      if (isVowel.test(s.charAt(j))) {
        count++;
      }
      int window = j - i + 1;
      if (window == k) {

        maxV = Math.max(maxV, count);

        if (isVowel.test(s.charAt(i))) {
          count--;
        }
        i++;
      }
      j++;
    }
    return maxV;
  }
}
