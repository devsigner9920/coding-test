package me.dvsgn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_128 {
    public static void main(String[] args) {
        Solution_L_128 s = new Solution_L_128();

        s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }
}

class Solution_L_128 {
    public int longestConsecutive(int[] nums) {
        var maxNum = Arrays.stream(nums).max().getAsInt();

        var check = new boolean[maxNum + 1];

        for (int num: nums) {
            check[num] = true;
        }

        int maxCount = 0;
        int count = 0;
        for (boolean b : check) {
            if (b) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            }

            if (!b) {
                count = 0;
            }
        }
        return maxCount;
    }
}
