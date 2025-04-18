package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

public class FloorOfANumber {
  public static void main(String[] args) {
    //    int[] arr = {2, 2, 2, 4, 4, 7, 11, 12, 16};
    //    int target = 8;
    //    print(floorOfANumber(arr, target));
    //    print(floorOfANumber(arr, 1));
    char[] arr = {'c', 'f', 'j'};
    char target = 'a';
    char c = nextGreatestLetter(arr, target);
    print(c);
  }

  public static int floorOfANumber(int[] arr, int target) {
    int res = -1, start = 0, end = arr.length - 1, mid, curr;
    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = arr[mid];
      if (curr == target) {
        res = curr;
        break;
      } else if (target > curr) {
        res = curr;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }

  /**
   * 744. Find Smallest Letter Greater Than Target
   *
   * <p>You are given an array of characters letters that is sorted in non-decreasing order, and a
   * character target. There are at least two different characters in letters.
   *
   * <p>Return the smallest character in letters that is lexicographically greater than target. If
   * such a character does not exist, return the first character in letters.
   *
   * <p>Example 1:
   *
   * <p>Input: letters = ["c","f","j"], target = "a" Output: "c" Explanation: The smallest character
   * that is lexicographically greater than 'a' in letters is 'c'. Example 2:
   *
   * <p>Input: letters = ["c","f","j"], target = "c" Output: "f" Explanation: The smallest character
   * that is lexicographically greater than 'c' in letters is 'f'. Example 3:
   *
   * <p>Input: letters = ["x","x","y","y"], target = "z" Output: "x" Explanation: There are no
   * characters in letters that is lexicographically greater than 'z' so we return letters[0].
   *
   * <p>Constraints:
   *
   * <p>2 <= letters.length <= 104 letters[i] is a lowercase English letter. letters is sorted in
   * non-decreasing order. letters contains at least two different characters. target is a lowercase
   * English letter.
   */
  public static char nextGreatestLetter(char[] letters, char target) {
    int res = 0, start = 0, end = letters.length - 1, mid, curr;

    while (end >= start) {
      mid = start + (end - start) / 2;
      curr = letters[mid];
      if (curr == target) {
        start = mid + 1;
      } else if (target < curr) {
        end = mid - 1;
        res = curr;
      } else {
        start = mid + 1;
      }
    }
    return res == 0 ? letters[0] : (char) res;
  }
}
