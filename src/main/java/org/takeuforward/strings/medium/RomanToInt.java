package org.takeuforward.strings.medium;

import java.util.HashMap;

public class RomanToInt {

    public static void main(String[] args) {
        String s = "III";
        System.out.println("Roman number : " + s);
        System.out.println("Integer number : " + romanToInt(s));
        System.out.println("Integer number : " + romanToInt1(s));
        s = "LVIII";
        System.out.println("Roman number : " + s);
        System.out.println("Integer number : " + romanToInt(s));
        System.out.println("Integer number : " + romanToInt1(s));
        s = "MCMXCIV";
        System.out.println("Roman number : " + s);
        System.out.println("Integer number : " + romanToInt(s));
        System.out.println("Integer number : " + romanToInt1(s));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int prev = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int value = map.get(c);
            if (prev >= value) {
                sum += value;
            } else {
                sum -= prev;
                sum += value - prev;
            }
            prev = value;
        }

        return sum;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int romanToInt1(String s) {
        int sum = 0;
        int prev = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int value = toNumber(c);
            if (prev >= value) {
                sum += value;
            } else {
                sum -= prev;
                sum += value - prev;
            }
            prev = value;
        }

        return sum;
    }

    private static int toNumber(char c) {
        return switch(c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }
}
