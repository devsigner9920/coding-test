package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    private static int M = 6;
    private static int[] result = new int[M];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            var st = new StringTokenizer(br.readLine());
            var K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            var S = new int[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            var check = new boolean[K];

            go(0, 0, S, check);
            System.out.println();
        }
    }

    private static void go(int start, int depth, int[] S, boolean[] check) {
        if (depth == M) {
            for (int i = result.length - 2; i >= 0; i--) {
                if (result[i] > result[i + 1]) {
                    return;
                }
            }

            getOutput(result);
            return;
        }

        for (int i = start; i < S.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            result[depth] = S[i];
            go(start + 1, depth + 1, S, check);
            check[i] = false;
        }
    }

    private static void getOutput(int[] result) {
        var sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(result[i]);
            if (i != M - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
