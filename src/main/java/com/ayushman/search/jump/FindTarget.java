package com.ayushman.search.jump;

import static com.ayushman.utils.PrintUtils.print;

/** jump search applied on sorted array time complexity = O(sqrt(n)) */

public class FindTarget {
  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 7, 11, 34, 45, 65, 77};

    print(jumpSearch(arr, 11));
    print(jumpSearch(arr, 77));
    print(jumpSearch2(arr, 11));
    print(jumpSearch2(arr, 77));
  }

  private static int jumpSearch2(int[] arr, int target) {
    int n = arr.length,
        blockSize = (int) Math.sqrt(n),
        startIndex = 0,
        endIndex = blockSize,
        res = -1;

    while (endIndex < n && arr[endIndex] <= target) {
      startIndex = endIndex;
      endIndex += blockSize;
      if (endIndex > n) {
        endIndex = n;
      }
    }
    for (int i = startIndex; i < endIndex; i++) {
      if (arr[i] == target) {
        res = i;
        break;
      }
    }
    return res;
  }

  private static int jumpSearch(int[] arr, int target) {
    int startIndex = 0;
    int n = arr.length;
    int blockSize = (int) Math.sqrt(n);
    int endIndex = blockSize;

    while (endIndex < n && arr[endIndex] <= target) {
      startIndex = endIndex;
      endIndex = endIndex + blockSize;
      if (endIndex > n) {
        endIndex = n;
      }
    }
    int res = -1;
    for (int i = startIndex; i < endIndex; i++) {
      if (arr[i] == target) {
        res = i;
        break;
      }
    }
    return res;
  }
}
