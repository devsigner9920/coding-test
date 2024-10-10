package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {
    private static List<Integer>[] nearList;
    private static boolean[] visit;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var line = br.readLine().split(" ");
        var N = Integer.parseInt(line[0]);
        // 간선의 갯수
        var M = Integer.parseInt(line[1]);
        visit = new boolean[N];

        nearList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            nearList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            var st = new StringTokenizer(br.readLine(), " ");

            var v = Integer.parseInt(st.nextToken());
            var e = Integer.parseInt(st.nextToken());

            nearList[v].add(e);
            nearList[e].add(v);
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (answer == 1) {
            return;
        }

        if (depth == 4) {
            answer = 1;
            return;
        }

        visit[start] = true;
        for (int i: nearList[start]) {
            if (!visit[i]) {
                dfs(i, depth + 1);
            }
        }
        visit[start] = false;
    }
}