package com.ayushman.utils;

public interface PrintUtils {
    static void divider() {
        System.out.println("============================");
    }

    static void divider(String tag) {
        System.out.printf("%s :============================%n", tag);
    }
}
