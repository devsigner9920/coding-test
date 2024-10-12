package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2178 {
    private static int N;
    private static int M;
    private static int R = Integer.MAX_VALUE;
    private static boolean[][] check;
    private static int[][] S;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            var tempArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                S[i][j] = Character.getNumericValue(tempArr[j]);
            }
        }

        dfs(0, 0, 1);
        System.out.println(R);
    }

    private static void dfs(int i, int j, int result) {
        if (i == N - 1&& j == M - 1) {
            if (R > result) {
                R = result;
                return;
            }
        }

        if (i < 0 || i == N || j < 0 || j == M) {
            return;
        }

        if (check[i][j]) {
            return;
        }

        if (S[i][j] == 0) {
            check[i][j] = true;
            return;
        }


        check[i][j] = true;
        dfs(i - 1, j, result + 1);
        dfs(i + 1, j, result + 1);
        dfs(i, j - 1, result + 1);
        dfs(i, j + 1, result + 1);
    }
}
