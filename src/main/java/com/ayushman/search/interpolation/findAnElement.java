package com.ayushman.search.interpolation;

import static com.ayushman.utils.PrintUtils.print;

public class findAnElement {
  public static void main(String[] args) {
    int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    int target = 12;
    print(find(arr, target));
  }

  private static int find(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1, index = -1, probePosition;

    while (lo <= hi && target >= arr[lo] && target <= arr[hi]) {
      // handle single element array
      if (arr[lo] == arr[hi]) {
        if (arr[lo] == target) {
          index = lo;
        }
        break;
      }
      probePosition = lo + (target - arr[lo]) * (hi - lo) / (arr[hi] - arr[lo]);
      if (arr[probePosition] == target) {
        index = probePosition;
        break;
      } else if (target > arr[probePosition]) {
        hi = probePosition - 1;
      } else {
        lo = probePosition + 1;
      }
    }
    return index;
  }
}

/**
 * public class Solution {
 *     public int findMedian(int[][] a) {
 *         int start = 0, n = a.length*a[0].length ,end = n, mid;
 *         int medianIndex= n/2;
 *         while(start <=end){
 *             mid = start + (end-start)/2;
 *             if(medianIndex > getSum(a, mid)){
 *                 start = mid +1;
 *             }else{
 *                 end = mid-1;
 *             }
 *         }
 *         return start;
 *     }
 *
 *     public static int getSum(int[][] a, int miduu){
 *         in
 *     }
 * }
 * */
