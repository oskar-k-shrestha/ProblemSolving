package org.takeuforward.strings.easy;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("First string : " + s);
        System.out.println("Second string : " + t);
        System.out.println("Is anagram? " + isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println("First string : " + s);
        System.out.println("Second string : " + t);
        System.out.println("Is anagram? " + isAnagram(s, t));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 1) {
            return s.equals(t);
        }
        int[] map = new int[26];
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map[s1[i] - 'a']++;
            map[s2[i] - 'a']--;
        }
        for (int count : map) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Note : method charAt() takes more time than s[] lookup.
     * We improved space complexity but compromised on runtime
     */
    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int count : map) {
            if (count != 0) return false;
        }
        return true;
    }
}
