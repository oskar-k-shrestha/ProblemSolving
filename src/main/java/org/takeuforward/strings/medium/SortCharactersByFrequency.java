package org.takeuforward.strings.medium;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Initial string : " + s);
        System.out.println("Sorted by char frequency : " + sort(s));
        System.out.println("Sorted by char frequency : " + sort1(s));
        System.out.println("Sorted by char frequency : " + sort2(s));
        s = "cccaaa";
        System.out.println("Initial string : " + s);
        System.out.println("Sorted by char frequency : " + sort(s));
        System.out.println("Sorted by char frequency : " + sort1(s));
        System.out.println("Sorted by char frequency : " + sort2(s));
        s = "Aabb";
        System.out.println("Initial string : " + s);
        System.out.println("Sorted by char frequency : " + sort(s));
        System.out.println("Sorted by char frequency : " + sort1(s));
        System.out.println("Sorted by char frequency : " + sort2(s));
        s = "raaeaedere";
        System.out.println("Initial string : " + s);
        System.out.println("Sorted by char frequency : " + sort(s));
        System.out.println("Sorted by char frequency : " + sort1(s));
        System.out.println("Sorted by char frequency : " + sort2(s));
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(n + max)
     */
    private static String sort(String s) {
        if (s.length() == 1 || s.length() == 2) return s;

        HashMap<Character, Integer> freq = new HashMap<>();
        int max = 0;
        // count freq
        for (char c : s.toCharArray()) {        // O(n)
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
            if (max < freq.get(c)) {
                max = freq.get(c);
            }
        }
        String[] rank = new String[max + 1];
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {   // O(n^2)
            if (rank[entry.getValue()] != null) {
                rank[entry.getValue()] = rank[entry.getValue()] + entry.getKey(); // O(n)
            } else {
                rank[entry.getValue()] = String.valueOf(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = rank.length - 1; i >= 0; i--) {    // O(n)
            if (rank[i] != null) {
                for (char c : rank[i].toCharArray()) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Time complexity : O(n * log(n))
     * Space complexity : O(n)
     */
    private static String sort1(String s) {
        if (s.length() == 1 || s.length() == 2) return s;

        HashMap<Character, Integer> freq = new HashMap<>();
        int max = 0;
        // count freq
        for (char c : s.toCharArray()) {        // O(n)
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
            if (max < freq.get(c)) {
                max = freq.get(c);
            }
        }
        PriorityQueue<Pair> pairs = new PriorityQueue<>((o1,o2) -> {
                if (o1.count > o2.count) {
                    return -1;
                } else if (o1.count == o2.count) {
                    return 0;
                }
                return 1;
        });
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) { // O(n * log(n))
            pairs.add(new Pair(entry.getValue(), entry.getKey()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pairs.isEmpty()) {          // O(n * log(n))
            Pair pair = pairs.poll();
            sb.append(String.valueOf(pair.character).repeat(pair.count));
        }
        return sb.toString(); // O(n)
    }

    private static class Pair {
        int count;
        char character;

        public Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }

    /**
     * Time complexity : O(n) 5 pass
     * Space complexity : O(n)
     */
    private static String sort2(String s) {
        if (s.length() == 1 || s.length() == 2) return s;

        // count frequency
        Map<Character, Integer> freq = new HashMap<>(128); // O(n)
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // fill the buckets
        List<List<Character>> buckets = new ArrayList<>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) { // O(n)
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) { // O(n)
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // build the string
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length(); i >= 0; i--) { // O(n)
            List<Character> characters = buckets.get(i);
            for (char character : characters) {
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
            }
        }

        return sb.toString(); // O(n)
    }

}
