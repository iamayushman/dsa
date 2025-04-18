package com.ayushman.array;

import static com.ayushman.utils.PrintUtils.print;

/**
 * <a href="https://leetcode.com/problems/find-closest-number-to-zero/">Leetcode Link</a>
 *
 * <p>2239. Find Closest Number to Zero Given an integer array nums of size n, return the number
 * with the value closest to 0 in nums. If there are multiple answers, return the number with the
 * largest value.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [-4,-2,1,4,8] Output: 1 Explanation: The distance from -4 to 0 is |-4| = 4. The
 * distance from -2 to 0 is |-2| = 2. The distance from 1 to 0 is |1| = 1. The distance from 4 to 0
 * is |4| = 4. The distance from 8 to 0 is |8| = 8. Thus, the closest number to 0 in the array is 1.
 * Example 2:
 *
 * <p>Input: nums = [2,-1,1] Output: 1 Explanation: 1 and -1 are both the closest numbers to 0, so 1
 * being larger is returned.
 *
 * <p>Constraints:
 *
 * <p>1 <= n <= 1000 -105 <= nums[i] <= 105
 */
public class ClosestToZero {
  public static void main(String[] args) {
    int[] nums = {-4, -2, 1, 4, 8};
    print(findClosestToZero(nums));
  }

  static int findClosestToZero(int[] nums) {
    int closest = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(closest) == nums[i]) {
        closest = nums[i];
      }
      if (Math.abs(nums[i]) < Math.abs(closest)) {
        closest = nums[i];
      }
    }
    return closest;
  }
}
