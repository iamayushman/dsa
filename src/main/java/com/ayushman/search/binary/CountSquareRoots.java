package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

public class CountSquareRoots {
  public static void main(String[] args) {
    print(sqrt(10));
    print(sqrt(9));
  }

  public static int sqrt(int num) {
    int start = 1, end = num, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      // instead of doing num = mid*mid do mid = num/mid
      if (mid <= num / mid) {
        // 11 -> 3
        if (num % mid == 0 && mid == num / mid) {
          return mid - 1;
        }
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start - 1;
  }
}
