import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] A;
    private static long[] D;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        A = new int[N];
        D = new long[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        D[0] = A[0];
        for (int i = 1; i < N; i++) {
            D[i] = Math.max(D[i - 1] + A[i], A[i]);
        }

        System.out.println(Arrays.stream(D).max().getAsLong());
    }
}
