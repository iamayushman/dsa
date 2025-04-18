package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

public class CountAllOccurrencesOfTarget {
  public static void main(String[] args) {
    int[] arr = {2, 2, 2, 4, 4, 4, 4, 8, 12, 16};
    int target = 4;

    print(countAllOccurrencesOfTarget(arr, target));
  }

  public static int countAllOccurrencesOfTarget(int[] arr, int target) {
    int firstIndex = occurrencesOfTarget(arr, target, true);
    int lastIndex = occurrencesOfTarget(arr, target, false);
    return firstIndex == -1 ? 0 : lastIndex - firstIndex + 1;
  }

  public static int occurrencesOfTarget(int[] arr, int target, boolean isFirst) {
    int res = -1, start = 0, end = arr.length - 1, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;
      int el = arr[mid];
      if (el == target) {
        res = mid;
        if (isFirst) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (el > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
}
