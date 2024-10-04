package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_02 {
    private static int[] D = new int[10000];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        Arrays.fill(D, -1);
        System.out.println(dp(n));
    }

    private static int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (D[n] == -1) {
            if (n % 6 == 0) {
                D[n] = Math.min(dp(n - 1), Math.min(dp(n / 2), dp(n / 3))) + 1;
            } else if (n % 3 == 0) {
                D[n] = Math.min(dp(n - 1), dp(n / 3)) + 1;
            } else if (n % 2 == 0) {
                D[n] = Math.min(dp(n - 1), dp(n / 2)) + 1;
            } else {
                D[n] = dp(n - 1) + 1;
            }
        }

        return D[n];
    }
}
