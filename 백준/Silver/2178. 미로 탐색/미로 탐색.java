import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[][] S;
    private static boolean[][] check;
                                   //  상  하  좌  우
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S = new int[N][M];
        check = new boolean[N][M];
        var dist = new int[N][M];
        Queue<Pair_BOJ_2178> q = new LinkedList<>();
        q.add(new Pair_BOJ_2178(0, 0));
        dist[0][0] = 1;

        for (int i = 0; i < N; i++) {
            var a = br.readLine();
            for (int j = 0; j < M; j++) {
                S[i][j] = a.charAt(j) - '0';
            }
        }

        while (!q.isEmpty()) {
            var pair = q.remove();
            check[pair.x][pair.y] = true;

            for (int i = 0; i < 4; i++) {
                var nextX = pair.x + dx[i];
                var nextY = pair.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (S[nextX][nextY] == 0) {
                    continue;
                }

                if (check[nextX][nextY]) {
                    continue;
                }

                dist[nextX][nextY] = dist[pair.x][pair.y] + 1;
                q.add(new Pair_BOJ_2178(nextX, nextY));
                check[nextX][nextY] = true;
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}

class Pair_BOJ_2178 {
    final int x;
    final int y;

    Pair_BOJ_2178(int x, int y) {
        this.x = x;
        this.y = y;
    }
}