package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 선택해야할 블럭 갯수
        int K = Integer.parseInt(st.nextToken());

        var square = new int[N][M];

        for (int i = 0; i < N; i++) {
            var st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                square[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        var blocked = new boolean[N][M];


        go(N, M, K, square, blocked, 0, 0);
        System.out.println(result);
    }

    private static void go(int N, int M, int K, int[][] square, boolean[][] blocked, int depth, int sum) {
        if (K == depth) {
            if (result < sum) {
                result = sum;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (blocked[i][j]) {
                    continue;
                }

                if (i != 0) {
                    if (blocked[i - 1][j]) {
                        continue;
                    }
                }
                if (j != 0) {
                    if (blocked[i][j - 1]) {
                        continue;
                    }
                }
                if (i != N - 1) {
                    if (blocked[i + 1][j]) {
                        continue;
                    }
                }
                if (j != M - 1) {
                    if (blocked[i][j + 1]) {
                        continue;
                    }
                }

                blocked[i][j] = true;
                go(N, M, K, square, blocked, depth + 1, sum + square[i][j]);
                blocked[i][j] = false;
            }}
    }
}
