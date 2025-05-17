package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};

    print(searchInRotated(arr));
    print(searchInRotated2(arr, 0));
    print(searchInRotated2(arr, 1));
    print(searchInRotated2(arr, 5));
  }

  private static int searchInRotated2(int[] arr, int target) {
    int res = -1, n = arr.length;
    int start = 0, end = n - 1, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        res = mid;
        break;
      }
      if (arr[start] <= arr[mid]) { // in sorted part
        // .:|.:|
        if (target >= arr[start] && target < arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > arr[mid] && target <= arr[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }

    return res;
  }

  private static int searchInRotated(int[] arr) {
    int start = 0, n = arr.length, end = n - 1, mid;
    int target = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;

      if (arr[mid] == target) {
        return mid;
      }

      if (arr[start] <= arr[mid]) {
        if (target < arr[mid] && target >= arr[start]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > arr[mid] && target <= arr[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
}
