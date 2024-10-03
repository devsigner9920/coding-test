import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        dfs(n, 0);
        System.out.println(min);
    }

    private static void dfs(int n, int count) {
        if (count > min) {
            return;
        }
        
        if (n == 1) {
            min = Math.min(count, min);
            return;
        }

        if (n % 3 == 0) {
            dfs(n / 3, count + 1);
        }

        if (n % 2 == 0) {
            dfs(n / 2, count + 1);
        }

        dfs(n - 1, count + 1);
    }
}
