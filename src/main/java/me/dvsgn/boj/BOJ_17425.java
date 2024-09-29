package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17425 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        var fx = new long[1_000_001];
        var df = new long[1_000_001];

        Arrays.fill(fx, 1);
        fx[0] = 0;

        for (int i = 2; i < fx.length; i++) {
            for (int j = 1; j <= (fx.length - 1) / i; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < df.length; i++) {
            df[i] = df[i - 1] + fx[i];
        }

        for (int i : arr) {
            System.out.println(df[i]);
        }
    }
}
