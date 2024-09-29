package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var N = Integer.parseInt(st.nextToken());
        var M = Integer.parseInt(st.nextToken());
        var visited = new boolean[N + 1];
        var sequence = new int[M];
        backTrack(N, M, visited, sequence, 0);
    }

    private static void backTrack(int N, int M, boolean[] visited, int[] sequence, int depth) {
        if (depth == M) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < M; i++) {
                str.append(sequence[i]).append(" ");
            }
            str.trimToSize();
            System.out.println(str);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                backTrack(N, M, visited, sequence, depth + 1);
                visited[i] = false;
            }
        }
    }
}
