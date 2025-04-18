package com.ayushman.array;

import static com.ayushman.utils.PrintUtils.print;

/*
 * Accumulative sum array or Prefix sum array
 * */
public class PrefixSumArray {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5};
    print(arr);
    prefixSumArray(arr);
    print(arr);

    int[] arr2 = new int[] {1};
    print(arr2);
    prefixSumArray(arr2);
    print(arr2);
  }

  public static void prefixSumArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (i > 0) arr[i] += arr[i - 1];
    }
  }
}
