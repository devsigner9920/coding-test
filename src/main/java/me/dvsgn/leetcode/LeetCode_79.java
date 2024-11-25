package me.dvsgn.leetcode;

public class LeetCode_79 {
    public static void main(String[] args) {
        Solution_leet_79 sol = new Solution_leet_79();
        System.out.println(sol.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}

class Solution_leet_79 {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (bact(board, word, i, j, 0, new StringBuffer(), new boolean[board.length][board[i].length])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean bact(char[][] board, String word, int i, int j, int depth, StringBuffer result, boolean[][] check) {
        if (depth == word.length()) {
            if (result.toString().equals(word)) {
                return true;
            } else {
                return false;
            }
        }


        if (i < 0 || i >= board.length) {
            return false;
        }

        if (j < 0 || j >= board[0].length) {
            return false;
        }

        if (check[i][j]) return false;
        if (word.charAt(depth) != board[i][j]) return false;

        for (int k = 0; k < 4; k++) {
            result.append(board[i][j]);
            check[i][j] = true;
            if (bact(board, word, i + dx[k], j + dy[k], depth + 1, result, check)) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            check[i][j] = false;
        }

        return false;
    }
}