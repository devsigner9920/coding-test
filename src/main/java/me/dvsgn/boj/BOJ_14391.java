package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
    private static int N;
    private static int M;
    private static int max = Integer.MIN_VALUE;
    private static int[][] S;
    private static boolean[][] S_check;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N][M];
        S_check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            var temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        if (y == M) {
            dfs(x + 1, 0);
            return;
        }

        if (x == N) {
            sum();
            return;
        }

        // 가로로 증가 시키기
        S_check[x][y] = true;
        dfs(x, y + 1);

        // 세로로 증가 시키기
        S_check[x][y] = false;
        dfs(x, y + 1);
    }

    private static void sum() {
        int result = 0;
        // 가로 합
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                if (S_check[i][j]) {
                    temp *= 10;
                    temp += S[i][j];
                } else {
                    result+= temp;
                    temp = 0;
                }
            }
            result += temp;
        }
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (!S_check[j][i]) {
                    temp *= 10;
                    temp += S[j][i];
                } else {
                    result+= temp;
                    temp = 0;
                }
            }

            result += temp;
        }

        max = Math.max(max, result);
    }
}
