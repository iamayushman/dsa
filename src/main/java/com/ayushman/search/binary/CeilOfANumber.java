package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

public class CeilOfANumber {
  public static void main(String[] args) {
    int[] arr = {2, 2, 2, 4, 4, 7, 11, 12, 16};
    int target = 8;
    print(ceilOfANumber(arr, target));
    print(ceilOfANumber(arr, 1));
  }

  public static int ceilOfANumber(int[] arr, int target) {
    int res = -1, start = 0, end = arr.length - 1, mid, curr;
    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = arr[mid];
      if (curr == target) {
        res = curr;
        break;
      } else if (target > curr) {
        start = mid + 1;
      } else {
        res = curr;
        end = mid - 1;
      }
    }
    return res;
  }
}
