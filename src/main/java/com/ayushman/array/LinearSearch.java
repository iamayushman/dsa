package com.ayushman.array;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.print;

public class LinearSearch {
  public static void main(String[] args) {
    //    int[] arr = {1, 2, -3, -4, 4, 5, 6};
    //    int search = find1stOccurrence(arr, 4);
    //    print(search);

    //    int[] allOccurrence = findAllOccurrence(arr, 4);
    //    print("All occurrence", allOccurrence);

    //    int lastOccurrence = findLastOccurrence(arr, 4);
    //    print("Last occurrence", lastOccurrence);

    //    int lastOccurrence2 = findLastOccurrence2(arr, 4);
    //    print("Last occurrence 2", lastOccurrence2);

    //    print(arr);
    //    int max = findMax(arr);
    //    print("Max", max);

    //    int min = findMin(arr);
    //    print("Min", min);

    int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6, 7}, {1, 2}};
    print(arr);
    //    int[] index = findIn2dArray(arr, 5);
    //    print("index of 5 is : ", index);
    //
    //    int[][] indices = findAllOccurrencesIn2dArray(arr, 2);
    //    print(indices, "found element 2 at  : ");

    print(findSumSubArray(arr));
    print(findMaximumSumSubArray(arr));
  }

  private static int findMaximumSumSubArray(int[][] arr) {
    int n = arr.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

  private static int[] findSumSubArray(int[][] arr) {
    int n = arr.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      res[i] = sum;
    }
    return res;
  }

  private static int[][] findAllOccurrencesIn2dArray(int[][] arr, int target) {
    int n = arr.length;
    int size = 0;

    for (int i = 0; i < n; i++) {
      size += arr[i].length;
    }

    int[][] res = new int[size][2];
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == target) {
          res[count][0] = i;
          res[count][1] = j;
          count++;
        }
      }
    }
    return res;
  }

  private static int[] findIn2dArray(int[][] arr, int target) {
    int res = -1, n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[0];
  }

  private static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE; // or arr[0]
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  private static int findMin(int[] arr) {
    int max = Integer.MAX_VALUE; // arr[0]
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] < max) {
        max = arr[i];
      }
    }
    return max;
  }

  private static int findLastOccurrence2(int[] arr, int target) {
    int n = arr.length;
    for (int i = n - 1; i > 0; i--) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  private static int findLastOccurrence(int[] arr, int target) {
    int n = arr.length;
    int res = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i] == target && res < i) {
        res = i;
      }
    }
    return res;
  }

  private static int[] findAllOccurrence(int[] arr, int target) {
    int n = arr.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == target) {
        res[count++] = i;
      }
    }
    return res;
  }

  public static int find1stOccurrence(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
