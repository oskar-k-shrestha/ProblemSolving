package org.takeuforward.hash;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HashQuestions {
    public static void main(String[] args) {
        int[] nums = {10, 5, 10, 15, 10, 5};
        countFrequency(nums);
        findHighestAndLowestFrequency(nums);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static void countFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        // print the map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static void findHighestAndLowestFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        int minKey = 0;
        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
            if (entry.getValue() <= minValue) {
                minKey = entry.getKey();
                minValue = entry.getValue();
            }
        }

        System.out.println("MinKey: " + minKey + ", MinValue: " + minValue);
        System.out.println("MaxKey: " + maxKey + ", MaxValue: " + maxValue);
    }


}
