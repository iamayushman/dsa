package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

public class BitonicArray {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 4, 3, 2};
    int[] arr2 = {1, 2, 3, 4, 5};
    print("Is valid", isValidBitonicArr(arr));
    print("Is valid", isValidBitonicArr(arr2));

    print("Peak of bitonic/mountain array", peakElementOfBitonicArray(arr));
    print("Peak of bitonic/mountain array", peakElement(arr));
    print("Is valid", isValidBitonicArr(arr2));

    int[] arr3 = {1, 3, 5, 7, 4, 2};
    print("Find in bitonic/mountain array", findElementInBitonicArr(arr3, 4));
  }

  private static int findElementInBitonicArr(int[] arr3, int target) {
    // find peakḍ
    // bs in incresing
    // bs in decreasing
    return 0;
  }

  private static int peakElement(int[] arr) {
    int start = 0, n = arr.length, end = n - 1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;

      if (mid != 0 && mid != n - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return arr[mid];
      }

      if (mid != 0 && arr[mid + 1] > arr[mid]) {
        start = mid + 1;
      }
      if (mid != n - 1 && arr[mid] > arr[mid + 1]) {
        end = mid - 1;
      }
    }
    return -1;
  }

  private static int peakElementOfBitonicArray(int[] arr) {
    int start = 0, n = arr.length, end = n - 1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;

      if (mid != 0 && mid != n - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return arr[mid];
      } else if (mid != n - 1 && arr[mid] < arr[mid + 1]) {
        start = mid + 1;
      } else if (arr[mid] > arr[mid + 1]) {
        end = mid - 1;
      }
    }
    return -1;
  }

  private static boolean isValidBitonicArr(int[] arr) {
    int i = 0, n = arr.length;
    while (i < n - 1) {
      if (arr[i] < arr[i + 1]) {
        i++;
      } else {
        break;
      }
    }
    if (i == 0 || i == n - 1) {
      return false;
    }

    while (i < n - 1) {
      if (arr[i] > arr[i + 1]) {
        i++;
      } else {
        break;
      }
    }
    return i == n - 1;
  }
}
