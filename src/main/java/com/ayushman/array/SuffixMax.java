package com.ayushman.array;

import static com.ayushman.utils.PrintUtils.print;

public class SuffixMax {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    print(suffixMaxArray(arr));
  }

  public static int[] suffixMaxArray(int[] arr) {
    int n = arr.length;
    int[] res = new int[n];
    res[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      res[i] = Math.max(arr[i], res[i + 1]);
    }
    return res;
  }
}
