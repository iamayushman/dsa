package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.divider;
import static com.ayushman.utils.PrintUtils.print;

public class DecimalToBinary {
  public static void main(String[] args) {
    divider();
    print("Binary", convertToBinary(5));
    divider();
    print(convertToBinary(10));
    divider();
    print(convertToBinary(20));
    divider();
    print(convertToBinary(Integer.MAX_VALUE));

    divider();
    print("Binary to decimal", convertBinaryToDecimal(111));
    divider();
    print(convertBinaryToDecimal(10));
    divider();
    print(convertBinaryToDecimal(20));
    divider();
    print(convertBinaryToDecimal(Integer.MAX_VALUE));
  }

  static int convertBinaryToDecimal(int binary) {
    return convertAnyBaseToDecimal(binary, 2);
  }

  static int convertAnyBaseToDecimal(int binary, int base) {
    int res = 0;
    int power = 0;
    while (binary > 0) {
      int unit = binary % base;
      res += (int) (unit * Math.pow(base, power));
      binary /= 2;
      power++;
    }

    return res;
  }

  static long convertToBinary(int num) {
    return convertToBase(num, 2);
  }

  static long convertToBase(int num, int base) {
    // 10 -> 1010
    long res = 0;
    int power = 0;
    while (num != 0) {
      res += (int) ((num % base) * Math.pow(10, power));
      num /= 2;
      power++;
    }
    return res;
  }
}
