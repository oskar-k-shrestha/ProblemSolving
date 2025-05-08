package org.takeuforward.strings.easy;

public class LargestOddNumber {
    public static void main(String[] args) {
        String s = "35427";
        System.out.println("Input string : " + s);
        System.out.println("Largest odd number is : " + largest(s));
        System.out.println("Largest odd number is : " + largest1(s));
        s = "52";
        System.out.println("Input string : " + s);
        System.out.println("Largest odd number is : " + largest(s));
        System.out.println("Largest odd number is : " + largest1(s));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String largest(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            int number = s.charAt(i);
            if (number % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String largest1(String s) {
        int index = -1;
        index = s.lastIndexOf('1');
        index = Math.max(s.lastIndexOf('3'), index);
        index = Math.max(s.lastIndexOf('5'), index);
        index = Math.max(s.lastIndexOf('7'), index);
        index = Math.max(s.lastIndexOf('9'), index);
        return s.substring(0, index + 1);
    }
}
