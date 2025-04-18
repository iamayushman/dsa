package com.ayushman.strings;

import static com.ayushman.utils.PrintUtils.print;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/">Leetcode URL</a>
 *
 * <p>1768. Merge Strings Alternately You are given two strings word1 and word2. Merge the strings
 * by adding letters in alternating order, starting with word1. If a string is longer than the
 * other, append the additional letters onto the end of the merged string.
 *
 * <p>Return the merged string.
 *
 * <p>Example 1:
 *
 * <p>Input: word1 = "abc", word2 = "pqr" Output: "apbqcr" Explanation: The merged string will be
 * merged as so: word1: a b c word2: p q r merged: a p b q c r Example 2:
 *
 * <p>Input: word1 = "ab", word2 = "pqrs" Output: "apbqrs" Explanation: Notice that as word2 is
 * longer, "rs" is appended to the end. word1: a b word2: p q r s merged: a p b q r s Example 3:
 *
 * <p>Input: word1 = "abcd", word2 = "pq" Output: "apbqcd" Explanation: Notice that as word1 is
 * longer, "cd" is appended to the end. word1: a b c d word2: p q merged: a p b q c d
 *
 * <p>Constraints:
 *
 * <p>1 <= word1.length, word2.length <= 100 word1 and word2 consist of lowercase English letters.
 */
public class MergeTwoStrings {
  public static void main(String[] args) {
    String word1 = "abc", word2 = "pqr11";
    print(mergeAlternately(word1, word2));
  }

  public static String mergeAlternately(String word1, String word2) {
    StringBuilder sb = new StringBuilder();
    int n1 = word1.length();
    int n2 = word2.length();
    for (int i = 0; i < n1; i++) {
      sb.append(word1.charAt(i));
      if (i < n2) {
        sb.append(word2.charAt(i));
      }
    }
    if (n2 > n1) {
      sb.append(word2.substring(n1));
    }
    return sb.toString();
  }
}
