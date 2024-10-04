import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var N = Integer.parseInt(st.nextToken());
        var M = Integer.parseInt(st.nextToken());

        var arr = new int[N];
        var st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        var result = new int[M];
        var visited = new boolean[N];

        go(N, M, 0, 0, arr, visited, result);
        System.out.println(str);
    }

    private static void go(int N, int M, int depth, int start, int[] arr, boolean[] visited, int[] result) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                str.append(result[i]);

                if (i != M - 1) {
                    str.append(" ");
                }
            }
            str.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] = arr[i];
            go(N, M, depth + 1, i, arr, visited, result);
            visited[i] = false;
        }
    }
}
