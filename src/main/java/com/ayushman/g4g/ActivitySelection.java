package com.ayushman.g4g;

import java.util.Stack;

public class ActivitySelection {

    public static void main(String[] args) {
//        int[] start = {1, 3, 0, 5, 8, 5}, finish = {2, 4, 6, 7, 9, 9};
        int[] start = {5, 1, 3, 10, 2, 5, 4, 7, 2, 2}, finish = {10, 10, 9, 12, 10, 8, 4, 11, 10, 7};
        Stack<Integer> stack = new Stack<>();

//        5,  1,  3, 10, 2,  5, 4, 7,  2,  2
//        10, 10, 9, 12, 10, 8, 4, 11, 10, 7
//        5,  9,  6, 2,  8,  3, 0, 4,  8,  5
//        0,  0,  0, 0,  1,  1, 1, 0,  0,  0
        /*
        * start[i] < start[j] && finish[i] <= finish[j]
        *
        * */

        for (int i = 0; i < start.length; i++) {
            if (stack.isEmpty()) {
                stack.push(finish[i]);
            }
            if (!stack.isEmpty() && stack.peek() < start[i]) {
                stack.push(start[i]);
            }
        }
        int size = stack.size();
        System.out.println(size);
    }
}
