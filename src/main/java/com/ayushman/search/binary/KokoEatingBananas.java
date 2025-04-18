package com.ayushman.search.binary;

import static com.ayushman.utils.PrintUtils.print;

/**
 * 875. Koko Eating Bananas
 *
 * <p>Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * <p>Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of
 * bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of
 * them instead and will not eat any more bananas during this hour.
 *
 * <p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards
 * return.
 *
 * <p>Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * <p>Example 1:
 *
 * <p>Input: piles = [3,6,7,11], h = 8 Output: 4 Example 2:
 *
 * <p>Input: piles = [30,11,23,4,20], h = 5 Output: 30 Example 3:
 *
 * <p>Input: piles = [30,11,23,4,20], h = 6 Output: 23
 *
 * <p>Constraints:
 *
 * <p>1 <= piles.length <= 104 piles.length <= h <= 109 1 <= piles[i] <= 109
 */
public class KokoEatingBananas {
  public static void main(String[] args) {
    int[] piles = {30, 11, 23, 4, 20};
    int hours = 5;
    print(minEatingSpeed(piles, hours));
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int min = 1, max = Integer.MIN_VALUE, n = piles.length, start, end, mid, res = -1;

    for (int bananas : piles) {
      if (bananas > max) {
        max = bananas;
      }
    }
    start = min;
    end = max;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (canKokoEat(piles, mid, h)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return res;
  }

  private static boolean canKokoEat(int[] piles, int eatingSpeed, int h) {
    int hoursSpent = 0, n = piles.length;

    for (int i = 0; i < n; i++) {
      hoursSpent += piles[i] / eatingSpeed;
      if (piles[i] % eatingSpeed != 0) {
        hoursSpent += 1;
      }

      if (hoursSpent > h) {
        return false;
      }
    }

    return true;
  }
}
