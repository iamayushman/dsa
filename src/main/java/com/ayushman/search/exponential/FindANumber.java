package com.ayushman.search.exponential;

import static com.ayushman.search.BinarySearch.binarySearch;
import static com.ayushman.utils.PrintUtils.print;

public class FindANumber {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 5;
    print(find(arr, target));
  }

  private static int find(int[] arr, int target) {
    if (arr[0] == target) return 0;
    int index = -1;
    // range
    int i = 1;
    while (i < arr.length && arr[i] <= target) {
      i = 2 * i;
    }
    index = binarySearch(arr, target, i / 2, Math.min(i, arr.length));

    return index;
  }
}
