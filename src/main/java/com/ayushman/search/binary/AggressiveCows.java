package com.ayushman.search.binary;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.print;

/**
 * Given an array of length ‘N’, where each element denotes the position of a stall. Now you have
 * ‘N’ stalls and an integer ‘K’ which denotes the number of cows that are aggressive. To prevent
 * the cows from hurting each other, you need to assign the cows to the stalls, such that the
 * minimum distance between any two of them is as large as possible. Return the largest minimum
 * distance. Eg
 *
 * <p>array: 1,2,4,8,9 & k=3 O/P: 3 Explanation: 1st cow at stall 1 , 2nd cow at stall 4 and 3rd cow
 * at stall 8
 */
public class AggressiveCows {
  public static void main(String[] args) {
    int[] stables = {0, 3, 4, 7, 10, 9};
    int cows = 4;
    print(maximumOfMinimumDistance(stables, cows));
    print(maximumOfMinimumDistanceBS(stables, cows));
  }

  /** q ki hamara search array 0,1,2,3,4,5,6,7,8,9,10 tha, its possible to apply binary search */
  private static int maximumOfMinimumDistanceBS(int[] stables, int cows) {
    int res = -1, n = stables.length, start = 0, end = stables[n - 1] - stables[0], mid;
    while (start <= end) {
      mid = start + (end - start) / 2; // 5
      if (canBePlaced(stables, mid, cows)) {
        res = start;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }

  private static int maximumOfMinimumDistance(int[] stables, int cows) {
    Arrays.sort(stables);
    int n = stables.length;

    /*
     * hamara array kya hai 0,1,2,3,4,5,6,7,8,9,10 me se koi koi selected values hain
     * to minimum 2 cows kaha kaha ho skte hain jiska distance max ho???
     * ek ko ek kone me dusre ko dusre kone me dal do
     * ye hi range hoga hamara
     * min  = 1 ( minimum 2 cows 0 ya 1 pr ho skte h agr array chhota h to)
     * max = 10 (stables[n-1] - stables[0])
     * */
    int min = 1;
    int max = stables[n - 1] - stables[0];
    for (int i = min; i < max; i++) {
      if (!canBePlaced(stables, i, cows)) {
        return (i - 1);
      }
    }
    return -1;
  }

  private static boolean canBePlaced(int[] stables, int distance, int cows) {
    int countCows = 1, lastCowPosition = stables[0];
    for (int i = 1; i < stables.length; i++) {
      if (stables[i] - stables[lastCowPosition] >= distance) {
        countCows++;
        lastCowPosition = i;
      }
    }
    return countCows >= cows;
  }
}
