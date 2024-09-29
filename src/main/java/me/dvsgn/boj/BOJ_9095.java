package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var num = Integer.parseInt(br.readLine());
        for (var i = 0; i < num; i++) {
            var n = Integer.parseInt(br.readLine());
            var result = 0;
            result += sum(n);
            System.out.println(result);
        }
    }

    private static int sum(int n) {
        if (n == 0) { return 1; }
        if (n < 0) { return 0; }

        return sum(n - 1) + sum(n - 2) + sum(n - 3);
    }
}
