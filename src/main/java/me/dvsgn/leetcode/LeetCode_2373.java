package me.dvsgn.leetcode;

public class LeetCode_2373 {
    public static void main(String[] args) {
        Solution_2373 sol = new Solution_2373();
        sol.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}});
    }
}

class Solution_2373 {
    public int[][] largestLocal(int[][] grid) {
        var subN = grid.length - 2;
        var subGrid = new int[subN][subN];

        for (int i = 0; i < subN; i++) {
            for (int j = 0; j < subN; j++) {
                subGrid[i][j] = getMax(i, j, grid);
            }
        }

        return subGrid;
    }

    public int getMax(int row, int col, int[][] grid) {
        var max = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                var num = grid[i][j];
                if (max < num) {
                    max = num;
                }
            }
        }

        return max;
    }
}
