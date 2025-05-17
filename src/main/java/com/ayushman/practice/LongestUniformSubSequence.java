package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

public class LongestUniformSubSequence {
  public static void main(String[] args) {
    String input = "aabbbcccccdaaaa";
    print(longestUniformSubsequence(input));
  }

  private static int longestUniformSubsequence(String input) {
    // 0 -> n-1
    // char
    // count
    // continuous
    int n = input.length();
    if (n < 1) {
      return 0;
    }
    int count = 0;
    int maxCount = 0;
    char currentChar = input.charAt(0);
    for (int i = 0; i < n; i++) {
      char currentC = input.charAt(i);
      if (currentC == currentChar) {
        count++;
        maxCount = Math.max(maxCount, count);
      } else {
        currentChar = currentC;
        count = 1;
      }
    }

    return maxCount;
  }
}
