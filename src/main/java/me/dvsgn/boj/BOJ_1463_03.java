package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_03 {
    private static int[] D;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        D[0] = 0;
        dp(N);
        System.out.println(D[N]);
    }

    private static int dp(int n) {
        if (n == 1) {
            return 0;
        }

        if (D[n] > 0) {
            return D[n];
        }

        D[n] = dp(n - 1) + 1;
        if (n % 3 == 0) {
            int temp = dp(n / 3) + 1;
            if (temp < D[n]) {
                D[n] = temp;
            }
        }
        if (n % 2 == 0) {
            int temp = dp(n / 2) + 1;
            if (temp < D[n]) {
                D[n] = temp;
            }
        }

        return D[n];
    }
}
