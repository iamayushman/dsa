package com.ayushman.bitonic;

import static com.ayushman.utils.PrintUtils.print;

public class ValidateMountainArray {

  public static void main(String[] args) {
    int[] arr = {4, 4, 3, 2, 1};
    int[] arr2 = {0, 3, 2, 1};
    int[] arr3 = {3, 5, 5};
    print("Is mountain array? ", validate(arr));
    print("Is mountain array? ", validate(arr2));
    print("Is mountain array? ", validate(arr3));
  }

  public static boolean validate(int[] arr) {
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
