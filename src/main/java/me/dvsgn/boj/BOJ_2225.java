package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    private static int N;
    private static int K;
    private static long count;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 2;
        dfs(0, 0);
        System.out.println(count);
    }

    private static void dfs(int num, int depth) {
        if (depth == K) {
            if (num == N) {
                count++;
            }
            return;
        }

        if (num > N) {
            return;
        }

        for (int i = 1; i < N; i++) {
            dfs(num + i, depth + 1);
        }
    }
}
