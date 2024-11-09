package me.dvsgn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode_238 {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4};
        var result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        var acc = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            acc *= nums[i + 1];
            result[i] *= acc;
        }

        System.out.println(Arrays.toString(result));
    }
}
