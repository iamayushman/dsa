package com.ayushman.g4g;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateCharacter {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;

        boolean b = containsNearbyDuplicate(arr, k);
        System.out.println(MessageFormat.format("array {0} duplicate in {1} window size : {2}", Arrays.toString(arr), k, b));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        int i = 0, j = 0;

        while (j < n) {
            if (Math.abs(i - j) > k) {
                //shrink <mind to use i not j>
                st.remove(nums[i]);
                i++;
            }
            if (st.contains(nums[j])) {
                return true;
            }
            st.add(nums[j]);
            j++;
        }
        return false;
    }
}
