package me.dvsgn.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{-1, -1};
        int k = 2;
        var map = new HashMap<Integer, Integer>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                continue;
            }

            map.put(num, -1);
        }

        System.out.println(map);

        int[] ints = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).mapToInt(Map.Entry::getKey).limit(k).toArray();

//        for (int i = ints.length - 1; i >= 0; i--) {
//            ints[i];
//        }
        System.out.println(Arrays.toString(ints));
    }
}
