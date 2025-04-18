package com.ayushman.practice;

public class BinarySearch2 {
  public static void main(String[] args) {
    int[] arr = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int target = -5;
    System.out.println(find(arr, target));
  }

  private static int find(int[] arr, int target) {
    int res = -1, start = 0, n = arr.length, end = n - 1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        res = mid;
        break;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }
}
