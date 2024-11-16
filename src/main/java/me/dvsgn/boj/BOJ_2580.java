package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2580 {
    private static int n = 9;
    private static int[][] sudoku = new int[n][n];
    private static boolean[][] check = new boolean[n][n];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                var num = Integer.parseInt(st.nextToken());
                check[i][j] = num != 0;
                sudoku[i][j] = num;
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            var sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        if (sudoku[row][col] != 0) {
            sudoku(row, col + 1);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isValid(row, col, i)) {
                sudoku[row][col] = i;
                sudoku(row, col + 1);
            }
        }
        sudoku[row][col] = 0;
    }

    public static boolean isValid(int row, int col, int value) {
        for (int i = 0; i < n; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;

        for (int i = subRow; i < subRow + 3; i++) {
            for (int j = subCol; j < subCol + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
