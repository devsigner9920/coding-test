package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
    private static int N;
    private static int[] arr;
    private static boolean[] check;
    private static int maxGap = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        arr = new int[N];
        var result = new int[N];
        var st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0, result);
        System.out.println(maxGap);
    }

    private static void go(int depth, int[] result) {
        if (depth == N) {
            var gap = 0;
            for (int i = 0; i < N; i++) {
                if (i + 1 != N) {
                    gap += Math.abs(result[i] - result[i + 1]);
                }
            }
            maxGap = Math.max(maxGap, gap);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i]) continue;

            check[i] = true;
            result[depth] = arr[i];
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
