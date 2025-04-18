package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

public class SearchInRotatedSortedArray0 {
  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;

    print("Search index", nums, target, search(nums, target));
  }

  public static int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid, curr;
    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = nums[mid];

      if (curr == target) {
        return mid;
      }
      // look for target in sorted array
      else if (nums[start] <= curr) {
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

    return -1;
  }
}
