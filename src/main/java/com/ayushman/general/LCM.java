package com.ayushman.general;

public interface LCM {

    static void main(String[] args) {
        System.out.println(_LCM(3, 7));
    }

    static int _LCM(int a, int b) {
        return (a * b) / HCF._HCF(a, b);
    }
}


