package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {
    private static List<Integer> all = new ArrayList<>();
    private static java.util.Queue<Integer> queue = new LinkedList<>();
    private static ArrayList<Integer>[] graph;
    private static boolean[] check;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            all.add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        var count = 0;
        while (!all.isEmpty()) {
            queue = new LinkedList<>();
            bfs(all.remove(0));
            count++;
        }

        System.out.println(count);
    }

    private static void bfs(Integer v) {
        queue.add(v);
        check[v] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (all.contains(x)) {
                all.removeIf(integer -> integer == x);
            }

            for (int y : graph[x]) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
