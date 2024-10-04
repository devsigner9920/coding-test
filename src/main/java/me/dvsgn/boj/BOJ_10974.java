package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
    private static int N;
    private static boolean[] check;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        var result = new int[N];

        go(0, result);
    }

    private static void go(int depth, int[] result) {
        if (depth == N) {
            getOutput(result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i]) continue;

            check[i] = true;
            result[depth] = i + 1;
            go(depth + 1, result);
            check[i] = false;
        }
    }

    private static void getOutput(int[] result) {
        var sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
