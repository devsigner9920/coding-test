package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            var x = Integer.parseInt(br.readLine());
            sb.append(dp(x, 0)).append("\n");
        }

        System.out.println(sb);
    }

    private static int dp(int N, int targetNum) {
        if (N < 0) {
            return 0;
        }
        if (N == 0) {
            return 1;
        }

        switch (targetNum) {
            case 1: return dp(N - 3, 3) + dp(N - 2, 2);
            case 2: return dp(N - 3, 3) + dp(N - 1, 1);
            case 3: return dp(N - 2, 2) + dp(N - 1, 1);
            default: return dp(N - 3, 3) + dp(N - 2, 2) + dp(N - 1, 1);
        }
    }
}
