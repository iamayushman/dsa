package com.ayushman.sliding.window;

import java.util.ArrayDeque;

import static com.ayushman.utils.PrintUtils.print;

/**
 * 239. Sliding Window Maximum You are given an array of integers nums, there is a sliding window of
 * size k which is moving from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position. Return the max
 * sliding window. Example 1: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
 * Explanation: Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7
 * 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Example
 * 2: Input: nums = [1], k = 1 Output: [1] Constraints: 1 <= nums.length <= 105 -104 <= nums[i] <=
 * 104 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] res = solution1(nums, k);
    int[] res2 = solution2(nums, k);
    print(res);
    print(res2);
  }

  private static int[] solution2(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!deq.isEmpty() && deq.peekFirst() <= (i - k)) {
        deq.pollFirst();
      }

      while (!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]) {
        deq.pollLast();
      }

      deq.addLast(i);

      if (!deq.isEmpty() && i >= k - 1) {
        res[i - k + 1] = nums[deq.pollFirst()];
      }
    }
    return res;
  }

  /** Bruit force O(n^2) */
  private static int[] solution1(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++) {
      int windowMax = Integer.MIN_VALUE;
      for (int j = 0; j < k; j++) {
        if (nums[i + j] > windowMax) {
          windowMax = nums[i + j];
        }
      }
      res[i] = windowMax;
    }
    return res;
  }
}
