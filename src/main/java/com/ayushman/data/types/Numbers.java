package com.ayushman.data.types;

import com.ayushman.utils.PrintUtils;

public class Numbers {
    public static void main(String[] args) {
        System.out.println(Math.abs(-100));

        PrintUtils.divider("integer");
        System.out.println("Integer Size: " + Integer.SIZE);
        System.out.println("Integer Size: " + Integer.BYTES);

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(maxValue);
        System.out.println(String.valueOf(maxValue).length());
        System.out.println(minValue);
        System.out.println(String.valueOf(maxValue).length());
        System.out.println(Integer.highestOneBit(1));


        PrintUtils.divider("float");
        System.out.println("Float Size: " + Float.SIZE);

        System.out.println("Min: " + Float.MIN_VALUE + " Max: " + Float.MAX_VALUE);
        System.out.println("Min exponent: " + Float.MIN_EXPONENT + " Max Exponent: " + Float.MAX_EXPONENT);
        System.out.println("Min Normal: " + Float.MIN_NORMAL);
        System.out.println("Positive Infinity: " + Float.POSITIVE_INFINITY + " Negative Infinity: " + Float.NEGATIVE_INFINITY);
        System.out.println("Min Normal: " + Float.MIN_NORMAL);
        for (int i = -20; i < 20; i++) {
            System.out.println(i + " Binary: " + Integer.toBinaryString(i) + " Octal: " + Integer.toOctalString(i) + " Hex: " + Integer.toHexString(i) + " Hex: " + Integer.toUnsignedString(i, 16));
        }

        System.out.println(1 << 7);
        System.out.println(Byte.decode("-128"));

        PrintUtils.divider("double");
        System.out.println("Double Size: " + Double.SIZE);
        System.out.println("Double Size: " + Double.MAX_EXPONENT);

//        for (int i = 0; i < 100000; i++) {
//            System.out.println(i >>> 16);
//        }

    }
}
