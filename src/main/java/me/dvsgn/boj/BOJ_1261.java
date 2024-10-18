package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261 {
    private static int N;
    private static int M;
    private static int[][] S;
    private static boolean[][] check;
    private static Deque<Pair_BOJ_1261> q = new LinkedList<>();
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 벽을 뿌쉈을 때,
        // 벽을 안뿌쉈을 때
        // 두개로 나뉘어서 로직이 돌아가야함
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[M][N];
        check = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            var line = br.readLine();
            for (int j = 0; j < N; j++) {
                S[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        check[0][0] = true;
        q.add(new Pair_BOJ_1261(0, 0, 0));


        while (!q.isEmpty()) {
            var temp = q.remove();
            var x = temp.x;
            var y = temp.y;
            var breakCount = temp.breakCount;

            if (x == M - 1 && y == N - 1) {
                System.out.println(breakCount);
            }

            for (int i = 0; i < 4; i++) {
                var nextX = dx[i] + x;
                var nextY = dy[i] + y;

                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if (!check[nextX][nextY]) {
                        var isNotBreak = S[nextX][nextY] == 0;
                        if (isNotBreak) {
                            q.addFirst(new Pair_BOJ_1261(nextX, nextY, breakCount));
                        } else {
                            q.addLast(new Pair_BOJ_1261(nextX, nextY, breakCount + 1));
                        }

                        check[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}

class Pair_BOJ_1261 {
    final int x;
    final int y;
    final int breakCount;

    Pair_BOJ_1261(int x, int y, int breakCount) {
        this.x = x;
        this.y = y;
        this.breakCount = breakCount;
    }
}