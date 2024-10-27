package me.dvsgn.leetcode;

import java.util.*;

public class LeetCode_15 {
    public static void main(String[] args) {
        Solution_L_15 s = new Solution_L_15();

        s.threeSum(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }
}

class Solution_L_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            var set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                var complement = -(nums[i] + nums[j]);

                if (set.contains(complement)) {
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                }
                set.add(nums[j]);
            }
        }

        return result;
    }
}
