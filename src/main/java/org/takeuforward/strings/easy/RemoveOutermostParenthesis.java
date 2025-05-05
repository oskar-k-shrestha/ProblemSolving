package org.takeuforward.strings.easy;

import java.util.Stack;

public class RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println("Given string : " + s);
        System.out.println("After removing outer parenthesis : " + remove(s));
        System.out.println("After removing outer parenthesis : " + remove1(s));
        System.out.println("After removing outer parenthesis : " + remove2(s));
        System.out.println("After removing outer parenthesis : " + remove3(s));
        s = "(()())(())(()(()))";
        System.out.println("Given string : " + s);
        System.out.println("After removing outer parenthesis : " + remove(s));
        System.out.println("After removing outer parenthesis : " + remove1(s));
        System.out.println("After removing outer parenthesis : " + remove2(s));
        System.out.println("After removing outer parenthesis : " + remove3(s));
        s = "()()";
        System.out.println("Given string : " + s);
        System.out.println("After removing outer parenthesis : " + remove(s));
        System.out.println("After removing outer parenthesis : " + remove1(s));
        System.out.println("After removing outer parenthesis : " + remove2(s));
        System.out.println("After removing outer parenthesis : " + remove3(s));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String remove(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.peek().equals('(')) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // build string
                        if (start + 1 < i - 1) {
                            builder.append(s, start + 1, i);
                        }
                        start = i + 1;
                    }
                }
            }
        }
        return builder.toString();
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String remove1(String s) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int bucket = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bucket++;
            } else {
                    bucket--;
                    if (bucket == 0) {
                        // build string
                        if (start + 1 < i - 1) {
                            builder.append(s, start + 1, i);
                        }
                        start = i + 1;
                    }
            }
        }
        return builder.toString();
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String remove2(String s) {
        int startCount = 0;
        int endCount = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                startCount++;
            } else {
                endCount++;
            }
            if (startCount == endCount) {
                startCount = 0;
                endCount = 0;
            }else if (!(startCount == 1 && endCount == 0)){
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String remove3(String s) {
        StringBuilder builder = new StringBuilder();
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    builder.append(c);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
