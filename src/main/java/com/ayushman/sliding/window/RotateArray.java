package com.ayushman.sliding.window;

import java.util.Arrays;

import static com.ayushman.utils.PrintUtils.print;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        int co = 0;
        int start = 0;
        int end = d - 1;

        while (start <= (end / 2)) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;

            start++;
            end--;
            co++;
        }

        int i = 0;
        int j = d;
        while (i < arr.length - d) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j++;
            co++;
        }
        print(arr);
    }
}
