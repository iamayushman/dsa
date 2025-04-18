package com.ayushman.g4g;

public class Max {

    public static void main(String[] args) {
        int[] a = {1, 8, 7, 56, 90};
        int largest = largest(a);
        System.out.println(largest);
    }

    static int largest(int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

}
