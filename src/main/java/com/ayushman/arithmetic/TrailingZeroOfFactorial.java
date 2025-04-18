package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.print;

public class TrailingZeroOfFactorial {
  public static void main(String[] args) {
    print(trailingZeroOfFactorialValue(3));
    print(trailingZeroOfFactorialValue(5));
    print(trailingZeroOfFactorialValue(100));
  }

  private static int trailingZeroOfFactorialValue(int num) {
    int res = 0;
    for (int i = 5; i <= num; i *= i) {
      res = res + num / i;
    }
    return res;
  }
}
