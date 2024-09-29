package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15650 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var N = Integer.parseInt(st.nextToken());
        var M = Integer.parseInt(st.nextToken());
        var at = 1;
        var result = new int[M];

        go(at, N, M, 0, result);
    }

    private static void go(int at, int N, int M, int depth, int[] result) {
        if (depth == M) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < M; i++) {
                str.append(result[i]).append(" ");
            }
            System.out.println(str.toString().trim());
            return;
        }

        for (int i = at; i <= N; i++) {
            result[depth] = i;
            go(i + 1, N, M, depth + 1, result);
        }
    }
}
