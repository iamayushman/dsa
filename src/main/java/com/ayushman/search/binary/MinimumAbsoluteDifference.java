package com.ayushman.search.binary;

import static com.ayushman.search.binary.CeilOfANumber.ceilOfANumber;
import static com.ayushman.search.binary.FloorOfANumber.floorOfANumber;
import static com.ayushman.utils.PrintUtils.print;

public class MinimumAbsoluteDifference {
  public static void main(String[] args) {
    int[] arr = {2, 4, 8, 13, 17, 19};
    int[] arr2 = {2, 4, 8, 12, 13, 17, 19};
    int[] arr3 = {2};
    int[] arr4 = {2, 4, 8, 12, 13, 17, 19};
    int target = 12;
    //    print(minimumAbsoluteDifference(arr, target));
    //    print(minimumAbsoluteDifference(arr2, target));
    print(
        "minimum Absolute Difference", arr, target, minimumAbsoluteDifferenceSingleBS(arr, target));
    print(
        "minimum Absolute Difference",
        arr2,
        target,
        minimumAbsoluteDifferenceSingleBS(arr2, target));
    print(
        "minimum Absolute Difference",
        arr3,
        target,
        minimumAbsoluteDifferenceSingleBS(arr3, target));
    print("minimum Absolute Difference", arr4, 25, minimumAbsoluteDifferenceSingleBS(arr4, 25));
  }

  private static int minimumAbsoluteDifference(int[] arr, int target) {
    int floor = floorOfANumber(arr, target);
    int ceil = ceilOfANumber(arr, target);
    return Math.min(Math.abs(target - floor), Math.abs(target - ceil));
  }

  private static int minimumAbsoluteDifferenceSingleBS(int[] arr, int target) {
    int res = -1, start = 0, end = arr.length - 1, n = arr.length, mid, curr;
    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = arr[mid];
      if (curr == target) {
        res = mid;
        break;
      } else if (curr < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    int ans = 0;
    if (res == -1) { // element not found

      if (end == -1) { // smaller element then 1st
        ans = Math.abs(target - arr[start]);
      } else if (start == n) { // larger element then nth
        ans = Math.abs(target - arr[end]);
      } else { // somewhere in between
        ans = Math.min(Math.abs(target - arr[start]), Math.abs(target - arr[end]));
      }
    }
    return ans;
  }
}
