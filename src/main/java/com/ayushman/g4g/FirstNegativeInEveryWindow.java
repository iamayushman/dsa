package com.ayushman.g4g;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        List<Integer> integers = firstNegInt(arr, k);
        System.out.println(integers);
    }

    static List<Integer> firstNegInt(int[] arr, int k) {
        // write code here

        int n = arr.length;
        int i = 0, j = 0;

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        while (j < n) {
            if (arr[j] < 0) {
                deq.add(arr[j]);
            }
            int window = j - i + 1;
            if (window == k) {
                if (!deq.isEmpty()) {
                    res.add(deq.peek());
                } else {
                    res.add(0);
                }
                if (arr[i] < 0 && !deq.isEmpty()) {
                    deq.poll();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
