package com.ayushman.bitwise;

import static com.ayushman.utils.PrintUtils.divider;
import static com.ayushman.utils.PrintUtils.print;

public class BitwiseOperations {

  public static void main(String[] args) {
    print8BitBinary(35);
    print("find", findIthBit(35, 0));
    print("set", setIthBit(35, 3));
    print("unset", unsetIthBit(35, 1));
    print("toggle", toggleIthBit(35, 0));
    print("35 is power of 2", isPowerOf2(35));
    print("32 is power of 2", isPowerOf2(32));
    print8BitBinary(66);
    print8BitBinary(unsetRightmostSetBit(66));
    print("Total set bits in a number (66)", totalSetBitsInANumber(66));
    print(53);
    print8BitBinary(53);
    print("Clear LSB upto 3 of 53");
    print8BitBinary(clearLSBUptoI(53, 3));
    print("Clear MSB upto 3 of 53");
    print8BitBinary(clearMSBUptoI(53, 3));
    print("Clear MSB inclusive upto 3 of 53");
    print8BitBinary(clearLSBUptoIInclusive(53, 3));

    divider("Convert Character Case");
    print((char) setIthBit('A', 5));
    // or of upper case with space ' '
    print("ASCII of ' '", ' ');
    print8BitBinary(' ');
    print((char) ('A' | (1 << 5)));
    print((char) ('A' | ' '));
    print((char) unsetIthBit('a', 5));
    // and of lower case with uderscore '_'
    print("ASCII of ' '", '_');
    print8BitBinary('_');
    print((char) ('a' & ~(1 << 5)));
    print((char) ('a' & '_'));
    divider("XOR");
    divider("Swap number using XOR");
    swap(5, 6);
    print("XOR of A with 0 is A", 34 ^ 0);
    print("XOR of A with A is 0", 34 ^ 34);

    divider("Unique number in repeated array");
    int[] arr = {4, 5, 6, 2, 2, 3, 3, 1, 1, 4, 6};
    print("Unique element is: ", findUniqueNumberInRepeatedArray(arr));
    int[] arr1 = {5, 5, 6, 2, 2, 3, 3, 1, 1, 4};
    print("two Unique elements are: ");
    printTwoUniqueNumberInRepeatedArray(arr1);
  }

  private static int findUniqueNumberInRepeatedArray(int[] arr) {
    int res = 0;
    for (int j : arr) {
      res ^= j;
    }
    return res;
  }

  private static void printTwoUniqueNumberInRepeatedArray(int[] arr) {
    int res = 0;
    for (int j : arr) {
      res ^= j;
    }
    // 4^6
    int setBit = 0;
    int bit = 0;
    while (res != 0) {
      // find set bit
      if ((res >> bit & 1) != 0) {
        setBit = bit;
        break;
      }
      bit++;
    }

    int res1 = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] >> setBit & 1) != 0) {
        res1 = res1 ^ arr[i];
      }
    }
    int num1 = res ^ res1;
    int num2 = res1 ^ num1;

    print(num1, num2);
  }

  private static int clearLSBUptoI(int num, int bit) {
    return num & -(1 << bit + 1);
  }

  private static int clearMSBUptoI(int num, int bit) {
    return num & ((1 << bit) - 1);
  }

  private static int clearLSBUptoIInclusive(int num, int bit) {
    return num & ((1 << bit + 1) - 1);
  }

  private static int totalSetBitsInANumber(int n) {
    int count = 0;
    while (n != 0) {
      n = unsetRightmostSetBit(n);
      count++;
    }
    return count;
  }

  private static int unsetRightmostSetBit(int n) {
    return (n & n - 1);
  }

  public static void print8BitBinary(int num) {
    for (int i = 7; i >= 0; i--) {
      System.out.print((num >> i) & 1);
    }
    System.out.println();
  }

  public static int findIthBit(int num, int bit) {
    return num & (1 << bit);
  }

  public static int setIthBit(int num, int bit) {
    return num | (1 << bit);
  }

  public static int unsetIthBit(int num, int bit) {
    return num & (~(1 << bit));
  }

  public static int toggleIthBit(int num, int bit) {
    return num ^ (1 << bit);
  }

  public static boolean isPowerOf2(int num) {
    return (num & (num - 1)) == 0;
  }

  public static void swap(int num1, int num2) {
    print("Before swap", num1, num2);
    num1 = num1 ^ num2;
    num2 = num1 ^ num2;
    num1 = num1 ^ num2;
    print("After swap", num1, num2);
  }
}
