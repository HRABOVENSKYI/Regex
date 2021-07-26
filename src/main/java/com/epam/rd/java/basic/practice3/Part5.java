package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        System.out.println("94 --> " + decimal2Roman(94) + " --> " + roman2Decimal("XCIV"));
    }

    public static String decimal2Roman(int dec) {
        String[] romanCharacters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (dec >= romanValues[i]) {
                romanNumber.append(romanCharacters[i]);
                dec = dec - romanValues[i];
            }
        }
        return romanNumber.toString();
    }

    public static int roman2Decimal(String roman) {
        int res = 0;
        int step;
        for (int i = 0; i < roman.length(); i += step) {
            step = 1;
            int s1 = value(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int s2 = value(roman.charAt(i + 1));
                if (s1 >= s2) {
                    res += s1;
                } else {
                    res += s2 - s1;
                    step = 2;
                }
            } else {
                res += s1;
            }
        }
        return res;
    }

    static int value(char r) {
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] decimal = new int[]{1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < roman.length; i++) {
            if (r == roman[i]) {
                return decimal[i];
            }
        }
        return -1;
    }
}

