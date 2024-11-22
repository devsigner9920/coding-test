package me.dvsgn.leetcode;

public class LeetCode_2639 {
    public static void main(String[] args) {
        Solution_2639 sol = new Solution_2639();
        sol.findColumnWidth(new int[][]{{-15, 1, 3}, {15, 7, 12}, {125, 6, -2}});
    }
}

class Solution_2639 {
    public int[] findColumnWidth(int[][] grid) {
        var m = grid.length;
        var n = grid[0].length;

        var arr = new int[n];

        for (int i = 0; i < n; i++) {
            var temp = -1000000001;
            for (int j = 0; j < m; j++) {
                temp = Math.max(temp, (String.valueOf(grid[j][i])).length());
            }
            arr[i] = temp;
        }

        return arr;
    }
}