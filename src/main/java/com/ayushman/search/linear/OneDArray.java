package com.ayushman.search.linear;

public interface OneDArray {

    static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6};
        System.out.println(indexOf(arr, 4));
    }

    static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        throw new RuntimeException("Not found");
    }
}
