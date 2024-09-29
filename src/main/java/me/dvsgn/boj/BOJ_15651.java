package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
    private static final StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var N = Integer.parseInt(st.nextToken());
        var M = Integer.parseInt(st.nextToken());

        var result = new int[M];

        go(N, M, 0, result);
        System.out.println(str);
    }

    private static void go(int N, int M, int depth, int[] result) {
        if (depth == M) {

            for (int i = 0; i < M; i++) {
                str.append(result[i]);

                if (i != M - 1) {
                    str.append(" ");
                }
            }
            str.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            go(N, M, depth + 1, result);
        }
    }
}
