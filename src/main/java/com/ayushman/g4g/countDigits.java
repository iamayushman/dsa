package com.ayushman.g4g;

public class countDigits {

    public static void main(String[] args) {
        int i = evenlyDivides(43);
        System.out.println(i);
    }

    static int evenlyDivides(int n) {
        // code here
            int num = n;
            int count = 0;
            while (n > 0) {
                int d = n % 10;
                if (d > 0 && num % d == 0) {
                    count++;
                }
                n = n / 10;
            }
            return count;
    }
}
