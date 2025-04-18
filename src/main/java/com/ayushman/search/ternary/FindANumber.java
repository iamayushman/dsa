package com.ayushman.search.ternary;

import static com.ayushman.utils.PrintUtils.print;

public class FindANumber {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 5;
    print(find(arr, target));
  }

  private static int find(int[] arr, int target) {
    int start = 0, n = arr.length, end = n, index = -1, mid1, mid2;

    while (start <= end) {
      mid1 = start + (end - start) / 3;
      mid2 = end - (end - start) / 3;

      if (target >= arr[mid1]) {
        if (target == arr[mid1]) {
          index = mid1;
          break;
        }
        start = mid1 + 1;
      } else if (target <= arr[mid2]) {
        if (target == arr[mid2]) {
          index = mid2;
          break;
        }
        end = mid2 - 1;
      } else {
        start = mid1 + 1;
        end = mid2 - 1;
      }
    }
    return index;
  }
}
