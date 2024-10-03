import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] D = new int[1_001];
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        D[1] = 1;
        D[2] = 2;
        System.out.println(dp(n));
    }

    private static int dp(int n) {
        if (n <= 2) {
            return D[n];
        }
        if (D[n] != 0) {
            return D[n];
        }
        
        D[n] = (dp(n - 1) + dp(n - 2)) % 10_007;

        return D[n];
    }
}
