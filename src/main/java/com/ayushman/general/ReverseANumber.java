package com.ayushman.general;

public interface ReverseANumber {
    static void main(String[] args) {
        System.out.println(reverseANumber(123));
        System.out.println(reverseANumber(-123));

    }

    static int reverseANumber(int number) {
        boolean isNegative = number < 0;
        number = Math.abs(number);
        int res = 0;
        int maxPossible = Integer.MAX_VALUE / 10;
        while (number > 0) {
            int remainder = number % 10;
            if (res > maxPossible || (res == maxPossible && remainder > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            res = (res * 10) + (remainder);
            number /= 10;
        }
        return isNegative ? -res : res;
    }


}
