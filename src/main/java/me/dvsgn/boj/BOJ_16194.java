package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {
    private static int[] D;
    private static int[] P;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        P = new int[N + 1];
        P[0] = 0;

        var st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            var value = Integer.parseInt(st.nextToken());
            P[i] = value;
            D[i] = value;

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] = Math.min(D[i], D[i - j] + P[j]);
            }
        }

        System.out.println(D[N]);
    }
}