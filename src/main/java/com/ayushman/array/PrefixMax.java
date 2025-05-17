package com.ayushman.array;

import static com.ayushman.utils.PrintUtils.print;

public class PrefixMax {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    print(prefixMaxArray(arr));
  }

  public static int[] prefixMaxArray(int[] arr) {
    int[] res = new int[arr.length];
    res[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      res[i] = Math.max(arr[i], res[i - 1]);
    }
    return res;
  }
}
