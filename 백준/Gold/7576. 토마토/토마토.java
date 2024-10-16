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
    private static Queue<Pair_BOJ_7576> q = new LinkedList<>();
    private static int count = 0;
    public static void main(String[] args) throws IOException {
         var br = new BufferedReader(new InputStreamReader(System.in));
         var st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        S = new int[M][N];
        check = new boolean[M][N];

         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine(), " ");
             for (int j = 0; j < N; j++) {
                 var temp = Integer.parseInt(st.nextToken());
                 S[i][j] = temp;
                 if (temp == 1) {
                     q.add(new Pair_BOJ_7576(i, j));
                 }
             }
         }

         while (!q.isEmpty()) {
             var tempQ = new LinkedList<Pair_BOJ_7576>();
             while (!q.isEmpty()) {
                 var pair = q.remove();
                 var x = pair.x;
                 var y = pair.y;
                 check[x][y] = true;

                 for (int k = 0; k < 4; k++) {
                     int nx = x + dx[k];
                     int ny = y + dy[k];

                     if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                         continue;
                     }

                     if (S[nx][ny] == -1) {
                         continue;
                     }

                     if (check[nx][ny]) {
                         continue;
                     }

                     if (S[nx][ny] == 0) {
                         S[nx][ny] = 1;
                         check[nx][ny] = true;
                         tempQ.add(new Pair_BOJ_7576(nx, ny));
                     }
                 }
             }

             q.addAll(tempQ);
             if (!tempQ.isEmpty()) {
                 count++;
             }
         }

         for (int i = 0; i < M; i++) {
             for (int j = 0; j < N; j++) {
                 if (S[i][j] == 0) {
                     System.out.println(-1);
                     return;
                 }
             }
         }

        System.out.println(count);
    }
}

class Pair_BOJ_7576 {
    final int x;
    final int y;

    Pair_BOJ_7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}