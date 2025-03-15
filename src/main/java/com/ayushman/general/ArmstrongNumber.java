package com.ayushman.general;

public interface ArmstrongNumber {
    static void main(String[] args) {
        System.out.println(isArmstrongNumber(153));
        System.out.println(isArmstrongNumber(154));
    }

    static boolean isArmstrongNumber(int number) {
        var num = number;
        var res = 0;
        while (number > 0) {
            int remainder = number % 10;
            int pow = (int) Math.pow(remainder, 3);
            res += pow;
            number /= 10;
        }

        return res == num;
    }
}
