package com.ayushman.search;

import static com.ayushman.utils.PrintUtils.print;

public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = {-1, -2, 0, 2, 5, 7, 10};
    print(arr);
    print(binarySearch(arr, 10));
  }

  public static int binarySearch(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    return binarySearch(arr, target, start, end);
  }

  public static int binarySearch(int[] arr, int target, int start, int end) {
    int mid = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return mid;
  }
}
