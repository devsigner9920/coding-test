package me.dvsgn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_2762 {
    public static void main(String[] args) {
        Solution_2762 sol = new Solution_2762();
        System.out.println(sol.continuousSubarrays(new int[]{5, 4, 2, 4}));
    }
}

class Solution_2762 {
    public long continuousSubarrays(int[] nums) {
        // 배열 갯수를 처음에 1개부터 시작해서 nums.length -1개 까지 만들어본다
        // 다음에 고를 인덱스를 전달한다.
        return brute(nums, 0, new ArrayList<>());
    }

    private long brute(int[] nums, int index, List<Integer> result) {
        var count = 0L;
        if (isOk(result)) {
            count++;
        }

        if (index == nums.length) return 0L;

        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            count += brute(nums, i + 1, result);
            result.remove(result.size() - 1);
        }

        return count;
    }

    private boolean isOk(List<Integer> result) {
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                var temp = Math.abs(result.get(i) - result.get(j));

                if (temp < 0 || temp > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
