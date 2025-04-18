package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.print;

public class PowerOfANumber {
  public static void main(String[] args) {
    print(power(2, 2));
    print(power(10, 10));
  }

  public static long power(int num, int n) {
    long res = 1; // important to initialize from 1 not 0;
    for (int i = 0; i < n; i++) {
      res *= num;
    }
    return res;
  }
}
