package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    private static Queue<Pair_BOJ_7562> q = new LinkedList<>();
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[][] S;
    private static int[][] dist;
    private static boolean[][] check;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            var n = Integer.parseInt(br.readLine());
            S = new int[n][n];
            dist = new int[n][n];
            check = new boolean[n][n];
            var st1 = new StringTokenizer(br.readLine());
            var current = new Pair_BOJ_7562(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));
            var st2 = new StringTokenizer(br.readLine());
            var target = new Pair_BOJ_7562(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));

            if (current.equals(target)) {
                System.out.println(0);
                continue;
            }
            bfs(current, target);
            System.out.println(dist[target.x][target.y]);
        }
    }

    private static void bfs(Pair_BOJ_7562 current, Pair_BOJ_7562 target) {
        q.add(current);
        check[current.x][current.y] = true;
        dist[current.x][current.y] = 0;

        while (!q.isEmpty()) {
            var cur = q.remove();

            for (int i = 0; i < 8; i++) {
                var nextX = dx[i] + cur.x;
                var nextY = dy[i] + cur.y;

                if (nextX < 0 || nextX >= dist.length || nextY < 0 || nextY >= dist.length) {
                    continue;
                }

                if (check[nextX][nextY]) {
                    continue;
                }

                check[nextX][nextY] = true;
                dist[nextX][nextY] = dist[cur.x][cur.y] + 1;
                q.add(new Pair_BOJ_7562(nextX, nextY));
            }
        }
    }
}

class Pair_BOJ_7562 {
    final int x;
    final int y;

    Pair_BOJ_7562(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair_BOJ_7562 that = (Pair_BOJ_7562) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}