package com.ayushman.array;

import static com.ayushman.array.PrefixMax.prefixMaxArray;
import static com.ayushman.array.SuffixMax.suffixMaxArray;
import static com.ayushman.utils.PrintUtils.print;

public class TrappingRainWater {
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    print(trappingRainWater(arr));
    print(trappingRainWater2(arr));
  }

  private static int trappingRainWater2(int[] arr) {
    int left = 0, right = arr.length - 1, leftMax = 0, rightMax = 0, total = 0;
    while (left < right) {
      if (arr[left] <= arr[right]) {
        if (leftMax > arr[left]) {
          total += leftMax - arr[left];
        } else {
          leftMax = arr[left];
        }
        left++;
      } else {
        if (rightMax > arr[right]) {
          total += rightMax - arr[right];
        } else {
          rightMax = arr[right];
        }
        right--;
      }
    }
    return total;
  }

  // space = O(2n), time = O(3n)
  private static int trappingRainWater(int[] arr) {
    int[] prefixMax = prefixMaxArray(arr);
    int[] suffixMax = suffixMaxArray(arr);
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      int leftMax = prefixMax[i];
      int rightMax = suffixMax[i];
      if (arr[i] < leftMax && arr[i] < rightMax) {
        sum += Math.min(leftMax, rightMax) - arr[i];
      }
    }
    return sum;
  }
}
