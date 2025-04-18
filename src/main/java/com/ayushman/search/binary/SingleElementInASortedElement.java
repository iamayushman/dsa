package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

/**
 * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Leetcode link</a>
 *
 * <p>540. Single Element in a Sorted Array
 *
 * <p>You are given a sorted array consisting of only integers where every element appears exactly
 * twice, except for one element which appears exactly once.
 *
 * <p>Return the single element that appears only once.
 *
 * <p>Your solution must run in O(log n) time and O(1) space.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,1,2,3,3,4,4,8,8] Output: 2 Example 2:
 *
 * <p>Input: nums = [3,3,7,7,10,11,11] Output: 10
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 105 0 <= nums[i] <= 105
 */
public class SingleElementInASortedElement {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    print(singleElementInASortedElement(nums));
  }

  private static int singleElementInASortedElement(int[] nums) {
    int n = nums.length, start = 0, end = n - 2, mid;

    while (start <= end) {
      mid = start + (end - start) / 2;

      if (nums[mid] == nums[mid ^ 1]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return nums[start];
  }
}
