package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_02 {
    private static int[] D = new int[10000000];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            D[0] = 0;
            D[1] = 1;
            D[2] = 2;
            D[3] = 4;
            int a = dp(k);
            System.out.println(a);
        }
    }

    private static int dp(int n) {
        if (n <= 3) {
            return D[n];
        }

        if (D[n] != 0) {
            return D[n];
        }

        D[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);

        return D[n];
    }
}
