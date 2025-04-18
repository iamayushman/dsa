package com.ayushman.sorting;

import java.util.Arrays;

public interface SelectionSort {
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
        int[] arr3 = new int[]{-100, -200, -300};
        sort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int lastIndex = n - i - 1;
            int maxIndex = getMax(arr, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
    }

    static void swap(int[] arr, int maxIndex, int lastIndex) {
        if (arr[maxIndex] > arr[lastIndex]) {
            var tmp = arr[maxIndex];
            arr[maxIndex] = arr[lastIndex];
            arr[lastIndex] = tmp;
        }
    }

    static int getMax(int[] arr, int lastIndex) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
