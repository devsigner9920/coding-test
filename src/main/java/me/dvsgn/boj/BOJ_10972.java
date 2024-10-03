package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972 {
    private static boolean findAnswer = false;
    private static boolean isExit = false;
    private static int N;
    private static int[] target;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        check = new boolean[N];
        var result = new int[N];

        var isEarlyEnd = true;
        for (int i = N; i > 0; i--) {
            if (target[N - i] != i) {
                isEarlyEnd = false;
                break;
            }
        }

        if (isEarlyEnd) {
            System.out.println(-1);
            return;
        }
        go(0, result);
    }

    private static void go(int depth, int[] result) {
        if (isExit) {
            return;
        }

        if (depth == N && findAnswer) {
            getOutput(result);
            isExit = true;
            return;
        }

        if (depth == N) {
            for (int i = 0; i < N; i++) {
                if (target[i] != result[i]) {
                    return;
                }
            }

            findAnswer = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i]) {
                continue;
            }
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
