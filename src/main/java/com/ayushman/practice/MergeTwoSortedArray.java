package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

public class MergeTwoSortedArray {
  public static void main(String[] args) {
    int[] arr1 = {1, 3, 5, 7, 9};
    int[] arr2 = {2, 4, 6, 8, 10, 11};

    print(merge(arr1, arr2));
    print(merge2(arr1, arr2));
  }

  private static int[] merge(int[] arr1, int[] arr2) {
    int n = arr1.length, m = arr2.length, N = m + n;
    int[] merged = new int[N];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      if (arr1[i] <= arr2[j]) {
        merged[k++] = arr1[i++];
      } else {
        merged[k++] = arr2[j++];
      }
    }

    while (j < m) {
      merged[k++] = arr2[j++];
    }
    while (i < n) {
      merged[k++] = arr1[i++];
    }

    return merged;
  }

  private static int[] merge2(int[] arr1, int[] arr2) {
    int n = arr1.length, m = arr2.length, o = m + n, i = 0, j = 0, k = 0;
    int[] merged = new int[o];

    while (i < n && j < m) {
      merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
    }
    while (i < n) {
      merged[k++] = arr1[i++];
    }
    while (j < m) {
      merged[k++] = arr2[j++];
    }
    return merged;
  }
}
