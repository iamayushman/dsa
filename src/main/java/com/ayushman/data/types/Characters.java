package com.ayushman.data.types;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

public class Characters {
    public static void main(String[] args) {
        System.out.println("Character.MIN_RADIX: " + Character.MIN_RADIX);
        System.out.println("Character.MAX_RADIX: " + Character.MAX_RADIX);

        Character c = Character.valueOf('a');
        System.out.println(c.charValue() + " " + c.hashCode() + " " + c.toString(2));

        System.out.println(Character.codePointAt("Ayushman", 0));
        System.out.println(Character.toCodePoint('z', 'z'));

        System.out.println(Character.codePointBefore("Ayushman", 1));
        System.out.println(Character.toChars(122));
        System.out.println(Character.isEmoji(122));
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getType('z'));
        System.out.println(Character.valueOf('a'));
        System.out.println(Character.reverseBytes('A'));
        System.out.println(Character.getName('|'));
//
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            if (!Character.isValidCodePoint(i)) {
//                System.out.println("i => " + i + ": " + Character.isValidCodePoint(i));
//                break;
//            }
//        }

//        Character.UnicodeBlock devanagari = Character.UnicodeBlock.DEVANAGARI;
//
//        System.out.println("SupportedUnicode: " + Character.UnicodeScript.values().length);
//
//        System.out.println(Character.digit('a', 16));
//        System.out.println(Character.isLetterOrDigit('a'));

//        for (int i = 'A'; i <= 'Z'; i++) {
//            System.out.println("i ->" + i + " : " + (char) i);
//        }
//
//        for (int i = 'a'; i <= 'z'; i++) {
//            System.out.println("i ->" + i + " : " + (char) i);
//        }

//        System.out.println("Character.MIN_VALUE: " + (char) (97 - 122));
//        System.out.println("Character.MAX_VALUE: " + Character.MAX_VALUE);
//        System.out.println("Character.MIN_SUPPLEMENTARY_CODE_POINT: " + Character.MIN_SUPPLEMENTARY_CODE_POINT);
    }
}
