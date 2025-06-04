package org.takeuforward.strings.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = " -042";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "42";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "1337c0d3";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "0-1";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "words and 987";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "-91283472332";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));

        s = "+1";
        System.out.println("Initial string : " + s);
        System.out.println("Atoi : " + atoi(s));
        System.out.println("Atoi : " + atoi1(s));
    }

    private static int atoi(String s) {
        int sign = 1;
        // 1. Remove any leading spaces
        s = s.trim();
        if (s.isEmpty()) return 0;
        // 2. Read negative sign if present
        int readerIndex = 0;
        if (s.charAt(0) == '-') {
            if (s.length() == 1) return 0;
            sign = -1;
            readerIndex = 1;
//            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            if (s.length() == 1) return 0;
//            s = s.substring(1);
            readerIndex = 1;
        }
        // 3. Skip leading zero and read the integers
        int firstNonZeroIndex = -1;
        for (int i = readerIndex; i < s.length(); i++) {
            if (s.charAt(i) != 0) {
                firstNonZeroIndex = i;
                break;
            }
        }
        if (firstNonZeroIndex == -1) return 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = firstNonZeroIndex; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                stringBuilder.append(s.charAt(i));
            } else {
                break;
            }
        }
        if (stringBuilder.isEmpty()) return 0;
        int value;
        try {
            value = sign * Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            // 4. Round between -2^31 < - > 2^31 - 1
            if (sign == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return value;
    }

    private static int atoi1(String s) {

        Pattern pattern = Pattern.compile("^\\s*([+-]?)0*([0-9]+)");
        Matcher matcher = pattern.matcher(s);

        String sign = null;
        String number = null;
        if (matcher.find()) {
            sign = matcher.group(1);
            number = matcher.group(2);
        }

        if (sign == null || number == null) return 0;
        int value = 0;
        try {
            value = (sign.equals("-") ? -1 : 1) * Integer.parseInt(number);
        } catch (NumberFormatException e) {
            if (sign.equals("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return value;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static int atoi2(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Using long to handle overflow cases

        if (s.isEmpty()) return 0;

        // Check for sign
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') { i++; }

        // Process numerical characters
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break; // Stop at non-numeric character

            res = res * 10 + (ch - '0'); // Convert char to number
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }
}
