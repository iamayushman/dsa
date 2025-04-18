package com.ayushman.array;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.divider;
import static com.ayushman.utils.PrintUtils.print;

/*
 * 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 *
 * Output: 3
 *
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 *
 * Output: 5
 *
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 *
 * Example 3:
 *
 * Input: nums = [1,1,1]
 *
 * Output: 2
 *
 * Explanation: You must delete one element.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 *
 * nums[i] is either 0 or 1.
 * */
public class LongestSubArrayAfterDelete1Element {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 0, 1};
    divider(Arrays.toString(nums));
    System.out.println(longestSubArrayAfterDelete1Element(nums));
    System.out.println(longestSubArrayAfterDelete1ElementSW1(nums));
    System.out.println(longestSubArrayAfterDelete1ElementSW2(nums));

    int[] nums2 = new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1};
    divider(Arrays.toString(nums2));
    System.out.println(longestSubArrayAfterDelete1Element(nums2));
    System.out.println(longestSubArrayAfterDelete1ElementSW1(nums2));
    System.out.println(longestSubArrayAfterDelete1ElementSW2(nums2));
  }

  /* O(n)
   *  [0,1,1,1,0,1,1,0,1]
   * */
  private static int longestSubArrayAfterDelete1ElementSW2(int[] nums) {
    int n = nums.length, res = 0, i = 0, j = 0, lastZeroIndex = -1;
    while (j < n) {
      if (nums[j] == 0) {
        i = lastZeroIndex + 1;
        lastZeroIndex = j;
      }
      res = Math.max(res, j - i);
      j++;
    }
    return res;
  }

  /* O(n)
   *  [0,1,1,1,0,1,1,0,1]
   * */
  private static int longestSubArrayAfterDelete1ElementSW1(int[] nums) {
    int n = nums.length, res = 0, i = 0, zeros = 0;

    for (int j = 0; j < n; j++) {
      if (nums[j] == 0) zeros++;
      while (zeros > 1) {
        if (nums[i] == 0) zeros--;
        i++;
      }
      // question says we can delete an element so window size  = j-i-1+1 = j-i
      res = Math.max(res, j - i);
    }
    return res;
  }

  /* O(n^2) */
  private static int longestSubArrayAfterDelete1Element(int[] nums) {
    int n = nums.length, res = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        res = Math.max(res, findMaxBySkipping(nums, i));
      }
    }

    return res;
  }

  private static int findMaxBySkipping(int[] nums, int skipIndex) {
    int res = 0, n = nums.length, count = 0;
    for (int i = 0; i < n; i++) {
      if (i == skipIndex) continue;
      if (nums[i] == 1) {
        count++;
        res = Math.max(res, count);
      } else {
        count = 0;
      }
    }
    return res;
  }
}
