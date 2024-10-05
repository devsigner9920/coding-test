package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990_02 {
    private static int[][] D = new int[1000000][4];

    public static void main(String[] args) throws IOException {
        D[1][1] = 1;

        D[2][2] = 1;

        D[3][1] = 1;
        D[3][2] = 1;
        D[3][3] = 1;

        for (int i = 4; i <= 1000000 - 1; i++) {
            D[i][1] = (D[i - 1][2] + D[i - 1][3]) % 1_000_000_009;
            D[i][2] = (D[i - 2][1] + D[i - 2][3]) % 1_000_000_009;
            D[i][3] = (D[i - 3][1] + D[i - 3][2]) % 1_000_000_009;
        }

        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            var x = Integer.parseInt(br.readLine());
            sb.append(
                    (D[x][1] + D[x][2] + D[x][3]) % 1_000_000_009
            ).append("\n");
        }

        System.out.println(sb);
    }
}
