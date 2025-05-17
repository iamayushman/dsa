package com.ayushman.array;

import static com.ayushman.utils.PrintUtils.print;

public class DailyTemperature {
  public static void main(String[] args) {
    /*
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     * */

    int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
    print(dailyTemperatures(arr));
  }

  public static int[] dailyTemperatures(int[] arr) {
    int n = arr.length, left = 0, right = 1, count = 0;
    int[] res = new int[n];
    while (right < n) {
      if (arr[right] > arr[left]) {
        res[left] = ++count;
        left++;
        right = left + 1;
        count = 0;
      } else {
        count++;
        right++;
      }
    }
    return res;
  }
}
