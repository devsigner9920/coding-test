package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_03 {
    private static int[] D = new int[11];
    public static void main(String[] args) throws IOException {
        D[0] = 1;

        for (int i = 1; i < 11; i++) {
            if (i - 1 >= 0) {
                D[i] += D[i - 1];
            }

            if (i - 2 >= 0) {
                D[i] += D[i - 2];
            }

            if (i - 3 >= 0) {
                D[i] += D[i - 3];
            }
        }

        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            var n = Integer.parseInt(br.readLine());

            System.out.println(D[n]);
        }
    }
}
