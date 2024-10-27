import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var h = Integer.parseInt(st.nextToken());
        var w = Integer.parseInt(st.nextToken());
        var x = Integer.parseInt(st.nextToken());
        var y = Integer.parseInt(st.nextToken());

        var b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            b[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                b[i + x][j + y] -= b[i][j];
            }
        }

        var sb = new StringBuffer();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(b[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
