package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

/**
 * 153. Find Minimum in Rotated Sorted Array Suppose an array of length n sorted in ascending order
 * is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * <p>[4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated 7 times. Notice
 * that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0],
 * a[1], a[2], ..., a[n-2]].
 *
 * <p>Given the sorted rotated array nums of unique elements, return the minimum element of this
 * array.
 *
 * <p>You must write an algorithm that runs in O(log n) time.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [3,4,5,1,2] Output: 1 Explanation: The original array was [1,2,3,4,5] rotated 3
 * times. Example 2:
 *
 * <p>Input: nums = [4,5,6,7,0,1,2] Output: 0 Explanation: The original array was [0,1,2,4,5,6,7]
 * and it was rotated 4 times. Example 3:
 *
 * <p>Input: nums = [11,13,15,17] Output: 11 Explanation: The original array was [11,13,15,17] and
 * it was rotated 4 times.
 *
 * <p>Constraints:
 *
 * <p>n == nums.length 1 <= n <= 5000 -5000 <= nums[i] <= 5000 All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */
public class MinimumInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums = {3, 4, 5, 1, 2};
    print("Search", nums, findMin(nums));
  }

  public static int findMin(int[] nums) {
    int start = 0, n = nums.length, end = n - 1, mid, min = Integer.MAX_VALUE;
    while (start <= end) {
      mid = start + (end - start) / 2;
      // sorted part
      if (nums[start] <= nums[mid]) {
        min = Math.min(min, nums[start]);
        start = mid + 1;
      } else { // unsorted part
        min = Math.min(min, nums[mid]);
        end = mid - 1;
      }
    }
    return min;
  }
}
