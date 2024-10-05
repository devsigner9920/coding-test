package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10884 {
    private static int[][] D = new int[10000][10];
    public static void main(String[] args) throws IOException {
        // D[i][j] = D[i - 1][j - 1] + D[i - 1][j + 1]
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                D[i][j] = 0;
                if (j - 1 >= 0) D[i][j] += D[i - 1][j - 1];
                if (j + 1 <= 9) D[i][j] += D[i - 1][j + 1];
                D[i][j] %= 1_000_000_000;
            }
        }

        long a = 0;
        for (int i = 0; i <= 9; i++) {
            a += D[N][i];
        }

        System.out.println(a % 1_000_000_000);
    }
}
