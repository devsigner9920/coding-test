package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_02 {
    private static int[] D;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        D = new int[n + 1];
        D[0] = 0;
        D[1] = 1;

        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + 1;
        }

        System.out.println(D[n]);
    }
}
