package com.ayushman.search.binary;

/**
 * 1011. Capacity To Ship Packages Within D Days
 *
 * <p>A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 * <p>The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship
 * with packages on the conveyor belt (in the order given by weights). We may not load more weight
 * than the maximum weight capacity of the ship.
 *
 * <p>Return the least weight capacity of the ship that will result in all the packages on the
 * conveyor belt being shipped within days days.
 *
 * <p>Example 1:
 *
 * <p>Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5 Output: 15 Explanation: A ship capacity of
 * 15 is the minimum to ship all the packages in 5 days like this: 1st day: 1, 2, 3, 4, 5 2nd day:
 * 6, 7 3rd day: 8 4th day: 9 5th day: 10
 *
 * <p>Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and
 * splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 *
 * <p>Input: weights = [3,2,2,4,1,4], days = 3 Output: 6 Explanation: A ship capacity of 6 is the
 * minimum to ship all the packages in 3 days like this: 1st day: 3, 2 2nd day: 2, 4 3rd day: 1, 4
 * Example 3:
 *
 * <p>Input: weights = [1,2,3,1,1], days = 4 Output: 3 Explanation: 1st day: 1 2nd day: 2 3rd day: 3
 * 4th day: 1, 1
 *
 * <p>Constraints:
 *
 * <p>1 <= days <= weights.length <= 5 * 104 1 <= weights[i] <= 500
 */
public class ShipmentWithinDays {
  public static void main(String[] args) {
    int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int days = 5;
    System.out.println(shipWithinDays(weights, days));
  }

  public static int shipWithinDays(int[] weights, int days) {
    int max = Integer.MIN_VALUE, sum = 0, start = 0, end = 0, mid, res = -1;

    // find max
    for (int weight : weights) {
      if (weight > max) {
        max = weight;
      }
      sum += weight;
    }
    start = max;
    end = sum;

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (shipmentPossible(weights, mid, days)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return res;
  }

  private static boolean shipmentPossible(int[] weights, int max, int days) {
    int capacity = 0;
    int day = 1;
    for (int weight : weights) {
      capacity += weight;
      if (capacity > max) {
        day++;
        capacity = weight;
      }
      if (day > days) {
        return false;
      }
    }
    return true;
  }
}
