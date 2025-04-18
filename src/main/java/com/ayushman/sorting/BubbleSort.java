package com.ayushman.sorting;

/*
 * Bubble Sort
 * Sinking Sort
 * Exchange Sort
 * */

import java.util.Arrays;

public interface BubbleSort {
    static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr0 = new int[]{3, 2, 5, 4, 1};
        sort(arr0);
        System.out.println(Arrays.toString(arr0));
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{-100, 3, 2, 5, 4, 1};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    static int[] sort(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            var swapped = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    var tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    swapped = true;
                }
                count++;
            }
            count++;

            if (!swapped) break;
        }
        System.out.println("Count: " + count);
        return arr;
    }

}
