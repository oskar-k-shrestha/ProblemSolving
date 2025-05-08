package org.takeuforward.strings.easy;

import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("Input string : " + s);
        System.out.println("Reverse words : " + reverse(s));
        System.out.println("Reverse words : " + reverse1(s));

        s = "  hello world  ";
        System.out.println("Input string : " + s);
        System.out.println("Reverse words : " + reverse(s));
        System.out.println("Reverse words : " + reverse1(s));


        s = "a good   example";
        System.out.println("Input string : " + s);
        System.out.println("Reverse words : " + reverse(s));
        System.out.println("Reverse words : " + reverse1(s));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String reverse(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> word = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.add(c);
            } else {
                if (!word.isEmpty()) {
                    while (!word.isEmpty()) {
                        ans.append(word.pop());
                    }
                    ans.append(' ');
                    word.setSize(0);
                }
            }
        }
        // last word
        if (!word.isEmpty()) {
            while (!word.isEmpty()) {
                ans.append(word.pop());
            }
        }
        return ans.toString().trim();
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static String reverse1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if (i != 0) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}
