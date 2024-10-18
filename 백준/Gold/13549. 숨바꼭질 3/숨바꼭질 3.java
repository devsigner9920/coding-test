import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static int N;
    private static int K;
    private static int[] dist = new int[200_000];
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            var pos = q.remove();

            var back = pos - 1;
            var front = pos + 1;
            var teleport = 2 * pos;

            if (teleport < 200_000 && (dist[teleport] == -1 || dist[teleport] > dist[pos])) {
                dist[teleport] = dist[pos];
                q.add(teleport);
            }
            
            if (back >= 0 && dist[back] == -1) {
                dist[back] = dist[pos] + 1;
                q.add(back);
            }

            if (front < 200_000 && dist[front] == -1) {
                dist[front] = dist[pos] + 1;
                q.add(front);
            }
        }

        System.out.println(dist[K]);
    }
}
