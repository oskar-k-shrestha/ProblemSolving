package org.takeuforward.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println("String s : " + s);
        System.out.println("String t : " + t);
        System.out.println("IsIsomorphic : " + isIsomorphic(s, t));
        System.out.println("IsIsomorphic : " + isIsomorphic1(s, t));

        s = "foo";
        t = "bar";
        System.out.println("String s : " + s);
        System.out.println("String t : " + t);
        System.out.println("IsIsomorphic : " + isIsomorphic(s, t));
        System.out.println("IsIsomorphic : " + isIsomorphic1(s, t));

        s = "paper";
        t = "title";
        System.out.println("String s : " + s);
        System.out.println("String t : " + t);
        System.out.println("IsIsomorphic : " + isIsomorphic(s, t));
        System.out.println("IsIsomorphic : " + isIsomorphic1(s, t));

        s = "badc";
        t = "baba";
        System.out.println("String s : " + s);
        System.out.println("String t : " + t);
        System.out.println("IsIsomorphic : " + isIsomorphic(s, t));
        System.out.println("IsIsomorphic : " + isIsomorphic1(s, t));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.isEmpty()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) return false;
            } else {
                map.put(c1, c2);
            }
            if (map1.containsKey(c2)) {
                if (c1 != map1.get(c2)) return false;
            } else {
                map1.put(c2, c1);
            }
        }
        return true;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static boolean isIsomorphic1(String s, String t) {
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            if (arr1[c1] != 0) {
                if (arr1[c1] != c2) return false;
            } else {
                arr1[c1] = c2;
            }
            if (arr2[c2] != 0) {
                if (arr2[c2] != c1) return false;
            } else {
                arr2[c2] = c1;
            }
        }
        return true;
    }
}
