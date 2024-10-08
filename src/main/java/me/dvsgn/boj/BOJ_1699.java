package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699 {
    private static int[] D = new int[100_000];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            D[i] = i;

            for (int j = 1; j * j <= i; j++) {
                if (D[i] > D[i - j * j] + 1) {
                    D[i] = D[i - j * j] + 1;
                }
            }
        }

        System.out.println(D[n]);
    }
}
