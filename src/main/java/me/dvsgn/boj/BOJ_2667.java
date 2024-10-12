package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2667 {
    private static int N;
    private static int[][] S;
    private static boolean[][] check;
    private static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            var tempArr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                S[i][j] = Character.getNumericValue(tempArr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j]) {
                    continue;
                }

                if (S[i][j] == 0) {
                    check[i][j] = true;
                    continue;
                }

                arr.add(dfs(i, j));
            }
        }

        System.out.println(arr.size());
        arr.sort(Integer::compareTo);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    private static Integer dfs(int i, int j) {
        if (i < 0 || i == N || j < 0 || j == N || S[i][j] == 0) {
            return 0;
        }

        if (check[i][j]) {
            return 0;
        }

        check[i][j] = true;
        return dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1) + 1;
    }
}
