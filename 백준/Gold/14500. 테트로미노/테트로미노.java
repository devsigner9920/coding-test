import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] p;
    private static boolean[][] check;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            p[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                bf(i, j, 0, 0);
                if (j + 2 < m) {
                    int temp = p[i][j] + p[i][j + 1] + p[i][j + 2];
                    if (i - 1 >= 0) {
                        int temp2 = temp + p[i - 1][j + 1];
                        if (max < temp2) max = temp2;
                    }
                    if (i + 1 < n) {
                        int temp2 = temp + p[i + 1][j + 1];
                        if (max < temp2) max = temp2;
                    }
                }
                if (i + 2 < n) {
                    int temp = p[i][j] + p[i + 1][j] + p[i + 2][j];
                    if (j + 1 < m) {
                        int temp2 = temp + p[i + 1][j + 1];
                        if (max < temp2) max = temp2;
                    }
                    if (j - 1 >= 0) {
                        int temp2 = temp + p[i + 1][j - 1];
                        if (max < temp2) max = temp2;
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void bf(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        if (x < 0 || x >= n || y < 0 || y >= m) return;

        if (check[x][y]) return;

        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            bf(x + dx[i], y + dy[i], depth + 1, sum + p[x][y]);
        }
        check[x][y] = false;
    }
}
