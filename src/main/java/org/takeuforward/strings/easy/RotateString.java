package org.takeuforward.strings.easy;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println("Input string : " + s);
        System.out.println("Goal string : " + goal);
        System.out.println("Is goal possible by rotation ? " + rotationValid(s, goal));
        System.out.println("Is goal possible by rotation ? " + rotationValid1(s, goal));

        s = "abcde";
        goal = "abced";
        System.out.println("Input string : " + s);
        System.out.println("Goal string : " + goal);
        System.out.println("Is goal possible by rotation ? " + rotationValid(s, goal));
        System.out.println("Is goal possible by rotation ? " + rotationValid1(s, goal));
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(n)
     */
    private static boolean rotationValid(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.length() == 1) {
            return s.equals(goal);
        }

        char[] chars = s.toCharArray();
        for (int i = 1; i <= s.length(); i++) {
            char firstChar = chars[0];
            // left rotate by 1
            for (int j = 1; j < s.length(); j++) {
                chars[j - 1] = chars[j];
            }
            chars[s.length() - 1] = firstChar;
            if (new String(chars).equals(goal)) return true;
        }
        return false;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static boolean rotationValid1(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.length() == 1) {
            return s.equals(goal);
        }

        String joined = s + s;
        return joined.contains(goal);
    }
}
