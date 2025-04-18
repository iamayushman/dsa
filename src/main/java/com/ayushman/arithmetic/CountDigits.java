package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.print;

public class CountDigits {
  public static void main(String[] args) {
    print("Wrong", count(011100));
    print("using count", count(1000), "using log", countUsingLog(1000));
    print("using count", count(0), "using log", countUsingLog(0));
    print("using count", count(-100), "using log", countUsingLog(-100));
  }

  public static int countUsingLog(int num) {
    if (num == 0) return 1;
    if (num < 0) num = Math.abs(num);
    return (int) Math.log10(num) + 1;
  }

  public static int count(int num) {
    var count = 0;
    if (num == 0) {
      count++;
    }
    num = Math.abs(num);
    while (num > 0) {
      num /= 10;
      count++;
    }
    return count;
  }
}
