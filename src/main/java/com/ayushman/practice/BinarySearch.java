package com.ayushman.practice;

public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int result1 = find(arr, 8);
    int result2 = find(arr, 3);
    int result3 = find(arr, -1);
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }

  private static int find(int[] arr, int target) {
    int res = -1, n = arr.length;
    int start = 0, end = n - 1, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;

      if (arr[mid] == target) {
        res = arr[mid];
        break;
      }
      if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return res;
  }
}
