package com.ayushman.general;

/* Also known as Euclid's GCD (Greatest Common Divisor)*/

public interface HCF {
    static void main(String[] args) {
        System.out.println(_HCF(4, 18));
    }

    static int _HCF(int a, int b) {
        if (a == 0) return b;
        return _HCF(b % a, a);
    }
}
