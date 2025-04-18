package com.ayushman.array;

import com.ayushman.constants.Constants;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.divider;
import static com.ayushman.utils.PrintUtils.print;

/*
 *
 * You are given a 0-indexed array nums of n integers, and an integer k.
 *
 * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
 *
 * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
 *
 * The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
 *
 * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 * */
public class KRadiusSubArray {

  public static void main(String[] args) {
    //    print("ans", kRadiusSubArraySol1(new int[] {1, 2, 3, 4, 5, 6, 7}, 2));
    print("ans", kRadiusSubArraySol1(new int[] {7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
    print("ans", kRadiusSubArraySol1(new int[] {100000}, 0));
    print("ans", kRadiusSubArraySol1(Constants.longIntegerArray, 40000));
    divider("Prefix sum");
    print("ans", kRadiusSubArraySol2(new int[] {7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
    print("ans", kRadiusSubArraySol2(new int[] {100000}, 0));
    print("ans", kRadiusSubArraySol2(Constants.longIntegerArray, 40000));
    divider("SW");
    print("ans", kRadiusSubArraySol3(new int[] {7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
    print("ans", kRadiusSubArraySol3(new int[] {100000}, 0));
    print("ans", kRadiusSubArraySol3(Constants.longIntegerArray, 40000));
  }

  /* Sliding window*/
  public static int[] kRadiusSubArraySol3(int[] s, int k) {
    int n = s.length;

    if (k == 0) return s;

    int windowSize = 2 * k + 1;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    if (n < windowSize) {
      return ans;
    }

    long sum = 0;
    int left = 0;
    int right = 2 * k;
    int i = k;
    for (int x = left; x <= right; x++) {
      sum += s[x];
    }
    ans[i] = (int) (sum / windowSize);
    i++;
    right++;
    while (right < n) {
      sum = sum + s[right] - s[left];
      ans[i] = (int) (sum / windowSize);
      right++;
      left++;
      i++;
    }

    return ans;
  }

  /* prefix sum*/
  public static int[] kRadiusSubArraySol2(int[] s, int k) {
    int n = s.length;

    int[] res = new int[n];
    long[] prefixSum = new long[n];
    Arrays.fill(res, -1);

    if (n < 2 * k + 1) return res;

    prefixSum[0] = s[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + s[i];
    }

    for (int i = k; i <= n - k - 1; i++) {
      int left = i - k;
      int right = i + k;
      long sum = prefixSum[right];
      if (left > 0) {
        sum -= prefixSum[left - 1];
      }
      res[i] = (int) sum / (2 * k + 1);
    }

    return res;
  }

  public static int[] kRadiusSubArraySol1(int[] s, int k) {
    int avg, n = s.length;
    print(n);
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      if (i < k || i >= n - k) {
        res[i] = -1;
        continue;
      }

      int sum = 0;
      int count = 0;
      for (int j = i - k; j <= i + k; j++) {
        sum += s[j];
        count++;
      }
      avg = sum / count;
      res[i] = avg;
    }

    return res;
  }
}
