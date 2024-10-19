import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int R;
    private static int[][] S;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        S = new int[N][M];

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        rorate();
    }

    private static void rorate() {
        var groupCount = Math.min(N, M) / 2;
        var groups = new ArrayList<ArrayList<Integer>>();
        for (int k = 0; k < groupCount; k++) {
            var g = new ArrayList<Integer>();

            for (int i = k; i < M - 1 - k; i++) {
                g.add(S[k][i]);
            }

            for (int i = k; i < N - 1 - k; i++) {
                g.add(S[i][M - 1 - k]);
            }

            for (int i = M - 1 - k; i >= 1 + k; i--) {
                g.add(S[N - 1 - k][i]);
            }

            for (int i = N - 1 - k; i >= 1 + k; i--) {
                g.add(S[i][k]);
            }

            groups.add(g);
        }

        for (int k = 0; k < groupCount; k++) {
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = R % len;
            for (int j = k; j < M - k; j++, index = (index + 1) % len) {
                S[k][j] = group.get(index);
            }
            for (int i = k + 1; i < N - k - 1; i++, index = (index + 1) % len) {
                S[i][M - k - 1] = group.get(index);
            }
            for (int j = M - k - 1; j > k; j--, index = (index + 1) % len) {
                S[N - k - 1][j] = group.get(index);
            }
            for (int i = N - k - 1; i > k; i--, index = (index + 1) % len) {
                S[i][k] = group.get(index);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(S[i][j] + " ");
            }
            System.out.println();
        }
    }
}
