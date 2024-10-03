import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int S;
    private static int[] arr;
    private static int count;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        var st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            M = i;
            var result = new int[M];
            go(0, 0, result);
        }
        System.out.println(count);
    }

    private static void go(int start, int depth, int[] result) {
        if (depth == M) {
            if (S == Arrays.stream(result).sum()) {
                count++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            go(i + 1, depth + 1, result);
        }
    }

    private static void getOutput(int[] result) {
        var sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(result[i]);
            if (i != M - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
