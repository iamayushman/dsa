package com.ayushman.strings;

import java.util.Stack;

import static com.ayushman.utils.PrintUtils.print;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">Leetcode Link</a>
 *
 * <p>392. Is Subsequence Given two strings s and t, return true if s is a subsequence of t, or
 * false otherwise.
 *
 * <p>A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * <p>Example 1:
 *
 * <p>Input: s = "abc", t = "ahbgdc" Output: true Example 2:
 *
 * <p>Input: s = "axc", t = "ahbgdc" Output: false
 *
 * <p>Constraints:
 *
 * <p>0 <= s.length <= 100 0 <= t.length <= 104 s and t consist only of lowercase English letters.
 *
 * <p>Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you
 * want to check one by one to see if t has its subsequence. In this scenario, how would you change
 * your code?
 */
public class SubsequenceStrings {
  public static void main(String[] args) {
    String s = "abc", t = "ahbgdc";
    //    print(isSubsequence(s, t));
    String s1 = "b", t1 = "abc";
    print(isSubsequence(s1, t1));
  }

  public static boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) {
      return true;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      stack.add(s.charAt(i));
    }
    for (int i = t.length() - 1; i >= 0; i--) {
      if (!stack.empty() && stack.peek() == t.charAt(i)) {
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
