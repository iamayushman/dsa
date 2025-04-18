package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

/**
 * 81. Search in Rotated Sorted Array II There is an integer array nums sorted in non-decreasing
 * order (not necessarily with distinct values).
 *
 * <p>Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k <
 * nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
 * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at
 * pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * <p>Given the array nums after the rotation and an integer target, return true if target is in
 * nums, or false if it is not in nums.
 *
 * <p>You must decrease the overall operation steps as much as possible.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true Example 2:
 *
 * <p>Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 5000 -104 <= nums[i] <= 104 nums is guaranteed to be rotated at some
 * pivot. -104 <= target <= 104
 */
public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums = {2, 5, 6, 0, 0, 1, 2};
    int target = 0;
    print("Search", nums, target, search(nums, target));
  }

  public static boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid, curr;
    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = nums[mid];

      if (curr == target) {
        return true;
      }
      // shrink if start and end are same
      if (curr == nums[start] && curr == nums[end]) {
        start++;
        end--;
      } else {
        // look for target in sorted array
        if (nums[start] <= curr) {
          if (target >= nums[start] && target < curr) {
            end = mid - 1;
          } else {
            start = mid + 1;
          }
          // look for target in unsorted array
        } else {
          if (target > nums[mid] && target <= nums[end]) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
      }
    }

    return false;
  }
}
