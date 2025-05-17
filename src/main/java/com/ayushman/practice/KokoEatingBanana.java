package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

public class KokoEatingBanana {


    public static void main(String[] args) {
        int[] bananas = {3, 6, 7, 11};
        int hours = 8;

        print(findMinimumSpeed(bananas, hours));
    }

    private static int findMinimumSpeed(int[] bananas, int hours) {
        int start = 1, end = Integer.MIN_VALUE, mid, res = -1;
        for (int i = 0; i < bananas.length; i++) {
            if (bananas[i] > end) {
                end = bananas[i];
            }
        }

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (canEatAllBananas(bananas, mid, hours)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    private static boolean canEatAllBananas(int[] bananas, int eatingSpeed, int hours) {
        int hoursSpend = 0;
        for (int banana : bananas) {
            hoursSpend += banana / eatingSpeed;
            if (banana % eatingSpeed != 0) {
                hoursSpend += 1;
            }
            if (hoursSpend > hours) {
                return false;
            }
        }
        return true;
    }


}

