package com.ayushman.bitwise;

import com.ayushman.utils.PrintUtils;

import java.text.MessageFormat;

public interface SumOfSubsetOfArray {
    static void main(String[] args) {

        int k = 20;

        PrintUtils.divider("till n by i -> n  ==>  i * 2^n");
        for (int i = 0; i <= k; i++) {
            System.out.println(MessageFormat.format("1<<{0} = {1}", i, (1 << i)));
        }

        PrintUtils.divider("find all even numbers till n by 1 -> n  ==>  i<<1");
        for (int i = 0; i <= k; i++) {
            System.out.println(MessageFormat.format("{0}<<1 = {1}", i, (i << 1)));
        }

        for (int i = 0; i <= k; i++) {
            System.out.println(MessageFormat.format("{0}*{1} = {2}", 1 << 10, i, (1 << 10) * i));
        }

        System.out.println(MessageFormat.format("{0} GB = {1} MB", 5, ((1 << 10) * 5)));
        System.out.println(MessageFormat.format("{0} MB = {1} GB", 5120, (5120 / (1 << 10))));


        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
//                if ((i & j) > 0)
                    System.out.println(MessageFormat.format("{0} & {1} = {2}", i, j, i & j));
            }
        }


        int[] arr = new int[]{1, 2, 3};
        /*
         * []
         * [1]
         * [2]
         * [3]
         * [12]
         * [13]
         * [23]
         * [123]
         * */

        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            PrintUtils.divider(mask);
            for (int i = 0; i < mask; i++) {
                System.out.println(MessageFormat.format("mask: {0} i: {1} : (1<<i) : {2} (mas & 1<<i): {3}", mask, i, (1 << i), mask & (1 << i)));
                if ((mask & (1 << i)) > 0) {
                    sum += arr[i];
                }
                System.out.println(i);
            }
            System.out.println("Sum: " + sum);
        }

    }
}
