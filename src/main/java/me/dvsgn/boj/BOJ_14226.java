package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
    private static int n;
    private static int[][] dist;
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        q.add(1);
        q.add(0);

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], -1);
        }
        // 1개를 먼저 넣었을 때
        dist[1][0] = 0;

        while (!q.isEmpty()) {
            var currentCount = q.remove();
            var clipBoard = q.remove();

            // 클립보드에 현재 숫자 복사하기 액션을 취할 때
            // 동시에 한번도 방문한 적이 없을 때
            // (s, c) -> (s, s)
            if (dist[currentCount][currentCount] == -1) {
                dist[currentCount][currentCount] = dist[currentCount][clipBoard] + 1;
                q.add(currentCount);
                q.add(currentCount);
            }

            // 클립보드에 있는 숫자를 복사했을 때
            // 동시에 한번도 방문한 적이 없을 때
            // (s, c) -> (s + c, c)
            if (currentCount + clipBoard <= n && dist[currentCount + clipBoard][clipBoard] == -1) {
                dist[currentCount + clipBoard][clipBoard] = dist[currentCount][clipBoard] + 1;
                q.add(currentCount + clipBoard);
                q.add(clipBoard);
            }

            // 현재 갯수 - 1 할 때
            // 동시에 한번도 방문한 적이 없을 때
            // (s, c) -> (s - 1, c)
            if (currentCount - 1 >= 0 && dist[currentCount - 1][clipBoard] == -1) {
                dist[currentCount - 1][clipBoard] = dist[currentCount][clipBoard] + 1;
                q.add(currentCount - 1);
                q.add(clipBoard);
            }
        }

        int answer = -1;
        for (int i = 0; i <= n; i++) {
            if(dist[n][i] != -1) {
                if (answer == -1 || answer > dist[n][i]) {
                    answer = dist[n][i];
                }
            }
        }

        System.out.println(answer);
    }
}
