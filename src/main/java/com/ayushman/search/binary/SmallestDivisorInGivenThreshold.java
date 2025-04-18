package com.ayushman.search.binary;

/**
 * <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/">Leetcode
 * Link</a> 1283. Find the Smallest Divisor Given a Threshold
 *
 * <p>Given an array of integers nums and an integer threshold, we will choose a positive integer
 * divisor, divide all the array by it, and sum the division's result. Find the smallest divisor
 * such that the result mentioned above is less than or equal to threshold.
 *
 * <p>Each result of the division is rounded to the nearest integer greater than or equal to that
 * element. (For example: 7/3 = 3 and 10/2 = 5).
 *
 * <p>The test cases are generated so that there will be an answer.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,5,9], threshold = 6 Output: 5 Explanation: We can get a sum to 17 (1+2+5+9)
 * if the divisor is 1. If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5
 * the sum will be 5 (1+1+1+2). Example 2:
 *
 * <p>Input: nums = [44,22,33,11,1], threshold = 5 Output: 44
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 5 * 104 1 <= nums[i] <= 106 nums.length <= threshold <= 106
 */
public class SmallestDivisorInGivenThreshold {
  public int smallestDivisor(int[] nums, int threshold) {
    int res = -1, start = 1, end = Integer.MIN_VALUE, mid, n = nums.length;
    for (int num : nums) {
      if (num > end) {
        end = num;
      }
    }

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (isValidThreshold(nums, mid, threshold)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private boolean isValidThreshold(int[] nums, int divisor, int threshold) {
    int sumOfDivision = 0;
    for (int i = 0; i < nums.length; i++) {
      sumOfDivision += nums[i] / divisor;
      if (nums[i] % divisor != 0) {
        sumOfDivision += 1;
      }
      if (sumOfDivision > threshold) {
        return false;
      }
    }
    return true;
  }
}
