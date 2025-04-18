package com.ayushman.practice;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.divider;
import static com.ayushman.utils.PrintUtils.print;

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">Leetcode link</a>
 *
 * <p>1710. Maximum Units on a Truck
 *
 * <p>You are assigned to put some amount of boxes onto one truck. You are given a 2D array
 * boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * <p>numberOfBoxesi is the number of boxes of type i. numberOfUnitsPerBoxi is the number of units
 * in each box of the type i. You are also given an integer truckSize, which is the maximum number
 * of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as
 * the number of boxes does not exceed truckSize.
 *
 * <p>Return the maximum total number of units that can be put on the truck.
 *
 * <p>Example 1:
 *
 * <p>Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4 Output: 8 Explanation: There are: - 1 box
 * of the first type that contains 3 units. - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each. You can take all the boxes of the first and
 * second types, and one box of the third type. The total number of units will be = (1 * 3) + (2 *
 * 2) + (1 * 1) = 8. Example 2:
 *
 * <p>Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10 Output: 91
 *
 * <p>Constraints:
 *
 * <p>1 <= boxTypes.length <= 1000 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 1 <= truckSize
 * <= 106
 */
public class MaximumUnitsOnTruck {
  public static void main(String[] args) {
    //    int[][] arr1 = {{1, 3}, {2, 2}, {3, 1}};
    //    int truckSize = 8;

    int[][] arr1 = {{5, 10}};
    int truckSize = 5;
    print(findMaximumUnitsOnTruck(arr1, truckSize));
    divider();
    int[][] arr2 = {{5, 10}, {2, 5}};
    int truckSize2 = 5;
    print(findMaximumUnitsOnTruck(arr2, truckSize2));
  }

  private static int findMaximumUnitsOnTruck(int[][] arr1, int truckSize) {
    int boxIdx = 0, unitsIdx = 1;
    Arrays.sort(arr1, (a, b) -> Integer.compare(b[unitsIdx], a[unitsIdx]));
    int units = 0;
    for (int[] box : arr1) {
      if (truckSize >= box[boxIdx]) {
        units += box[boxIdx] * box[unitsIdx];
        truckSize -= box[boxIdx];
      } else {
        units += truckSize * box[boxIdx];
        break;
      }
    }
    return units;
  }
}
