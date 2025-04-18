package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

/**
 * 34. Find First and Last Position of Element in Sorted Array Given an array of integers nums
 * sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * <p>If target is not found in the array, return [-1, -1].
 *
 * <p>You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstOccurrenceOfANumberInAnArray {
  public static void main(String[] args) {
    int[] arr = {2, 2, 4, 4, 8, 12, 16};
    int target = 4;

    print(firstOccurrenceOfANumberInAnArray(arr, target));
    print(lastOccurrenceOfANumberInAnArray(arr, target));
    // combine two functions into one
    print(occurrenceOfANumberInAnArray(arr, target, true));
    print(occurrenceOfANumberInAnArray(arr, target, false));
  }

  public static int occurrenceOfANumberInAnArray(int[] arr, int target, boolean isFirst) {
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
      } else if (el < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }

  public static int firstOccurrenceOfANumberInAnArray(int[] arr, int target) {
    int res = -1, start = 0, end = arr.length - 1, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;
      int el = arr[mid];
      if (el == target) {
        res = mid;
        end = mid - 1;
      } else if (el < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }

  public static int lastOccurrenceOfANumberInAnArray(int[] arr, int target) {
    int res = -1, start = 0, end = arr.length - 1, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;
      int el = arr[mid];
      if (el == target) {
        res = mid;
        start = mid + 1;
      } else if (el < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }
}
