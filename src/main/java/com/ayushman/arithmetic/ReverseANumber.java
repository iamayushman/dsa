package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.print;

public class ReverseANumber {
  public static void main(String[] args) {
    print(reverse(12345));
    print(reverse(876554321));
  }

  public static int reverse(int num) {
    var res = 0;
    while (num > 0) {
      var digit = num % 10;
      res *= 10;
      res += digit;
      num /= 10;
    }
    return res;
  }
}
