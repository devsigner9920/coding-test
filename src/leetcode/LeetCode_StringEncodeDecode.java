package me.dvsgn.leetcode;

import java.util.Arrays;

public class LeetCode_StringEncodeDecode {
    public static void main(String[] args) {
        var sb = new StringBuffer();
        var strs = new String[]{"hello", "world!"};
        for (String str: strs) {
            sb.append(str.length()).append("/").append(str);
        }

        var encode = sb.toString();

        int[] nums = new int[]{1, 2, 3, 4};
        Arrays.stream(nums).max().getAsInt();
    }
}
