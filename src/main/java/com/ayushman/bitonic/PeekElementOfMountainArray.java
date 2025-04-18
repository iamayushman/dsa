package com.ayushman.bitonic;

import static com.ayushman.utils.PrintUtils.print;

public class PeekElementOfMountainArray {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 2, 1};
    int[] arr2 = {0, 3, 2, 1};
    int[] arr3 = {3, 5, 0};
    print("peek of mountain array? ", peek(arr));
    print("peek of mountain array? ", peek(arr2));
    print("peek of mountain array? ", peek(arr3));
  }

  public static int peek(int[] arr) {
    int start = 0, n = arr.length, end = n - 1, mid, curr;
    while (start <= end) {
      mid = start + (end - start) / 2;
      curr = arr[mid];
      if (mid != 0 && mid != n - 1 && curr > arr[mid - 1] && curr > arr[mid + 1]) { // peak
        return mid;
      } else if (mid != n - 1 && curr < arr[mid + 1]) { // asc
        start = mid + 1;
      } else if (mid != 0 && curr > arr[mid + 1]) { // desc
        end = mid - 1;
      }
    }
    return -1;
  }
}
