package org.takeuforward.strings.medium;

public class MaximumNestingDepthOfTheParenthesis {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Input string : " + s);
        System.out.println("Max depth : " + maxDepth(s));
        s = "(1)+((2))+(((3)))";
        System.out.println("Input string : " + s);
        System.out.println("Max depth : " + maxDepth(s));
        s = "()(())((()()))";
        System.out.println("Input string : " + s);
        System.out.println("Max depth : " + maxDepth(s));
        s = "1";
        System.out.println("Input string : " + s);
        System.out.println("Max depth : " + maxDepth(s));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int maxDepth(String s) {
        int balance = 0;
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance > maxDepth) {
                maxDepth = balance;
            }
        }
        return maxDepth;
    }
}
