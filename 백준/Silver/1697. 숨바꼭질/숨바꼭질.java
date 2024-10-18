import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int A;
    private static int K;
    private static int dist[] = new int[1000000];
    private static boolean check[] = new boolean[1000000];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q.add(A);
        dist[A] = 0;
        check[A] = true;


        while (!q.isEmpty()) {
            var position = q.remove();

            var back = position - 1;
            var front = position + 1;
            var teleport = 2 * position;

            if (back >= 0) {
                if (!check[back]) {
                    dist[back] = dist[position] + 1;
                    check[back] = true;
                    q.add(back);
                }
            }

            if (front < 1000000) {
                if (!check[front]) {
                    dist[front] = dist[position] + 1;
                    check[front] = true;
                    q.add(front);
                }
            }

            if (teleport < 1000000) {
                if (!check[teleport]) {
                    dist[teleport] = dist[position] + 1;
                    check[teleport] = true;
                    q.add(teleport);
                }
            }
        }

        System.out.println(dist[K]);
    }
}
