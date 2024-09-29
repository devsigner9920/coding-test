package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17427 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Long.parseLong(br.readLine());

        System.out.println(calcFactorsSum(n));
    }

    private static long calcFactorsSum(long n) {
        // 1, 2, 5, 10
        var sum = 0L;
        for (int i = 1; i <= n; i++) {
            sum += (i * (n / i));
        }

        return sum;
    }
}
