package com.ayushman.bitwise;

import com.ayushman.utils.PrintUtils;

import java.util.stream.IntStream;

public interface ParityOfANumber {
    static void main(String[] args) {
        PrintUtils.divider("Binary representation of a number");
        bitwise();
        PrintUtils.divider("Binary representation of a number");
        bitwise2();


        PrintUtils.divider("Odd or even");
        System.out.println(checkParity(1));
        System.out.println(checkParity(2));
        System.out.println(checkParity(3));
        System.out.println(checkParity(99));


        for (int i = 0; i < 10; i++) {
            System.out.println(1 << i);
        }
        int count = 0;
        for (int i = 0; i < (1 << 3); i++) {
            System.out.println(i);
            count++;
        }
        System.out.println("count: " + count);
    }

    /*
     * 1st bit of a number is used to check parity
     * */
    static String checkParity(int a) {
        return a + " is " + ((a & 1) == 0 ? "Even" : "Odd");
    }

    static void bitwise() {
        int x = 10000;
        int n = 32;
        for (int i = 0; i < n; i++) {
            System.out.println((x & (1 << i)) + " 2^" + i);
        }

    }

    static void bitwise2() {
        int x = 1001;
        int n = 32;
        for (int i = n; i >= 0; i--) {
            System.out.println((x & (1 << i)) + " 2^" + i);
        }

    }
}
