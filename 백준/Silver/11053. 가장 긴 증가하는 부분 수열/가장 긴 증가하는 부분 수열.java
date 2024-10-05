import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var S = new int[N];
        var D = new int[N];

        D[0] = 1;

        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            var temp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (S[i] > S[j]) {
                    temp = Math.max(D[j] + 1, temp);
                }
            }
            D[i] = temp;
        }

        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp = Math.max(temp, D[i]);
        }

        System.out.println(temp);
    }
}
