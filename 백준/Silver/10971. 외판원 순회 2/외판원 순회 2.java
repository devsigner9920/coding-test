import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] pay;
    private static boolean[] check;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N];

        pay = new int[N][N];
        var result = new int[N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pay[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, result);
        System.out.println(min);
    }

    private static void go(int depth, int[] result) {
        if (depth == N) {
            var cost = 0;
            for (int i = 0; i < N; i++) {
                var currentCost = 0;
                if (i == N - 1) {
                    currentCost = pay[result[N - 1]][result[0]];
                } else {
                    currentCost = pay[result[i]][result[i + 1]];
                }
                if (currentCost == 0) {
                    return;
                }
                cost += currentCost;
            }
            min = Math.min(cost, min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i]) continue;

            check[i] = true;
            result[depth] = i;
            go(depth + 1, result);
            check[i] = false;
        }
    }

    private static void getOutput(int[] result) {
        var sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
