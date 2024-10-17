import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    private static int A;
    private static int K;
    private static int MAX = 100_001;
    private static int[] dist;
    private static boolean[] check;
    private static int[] paths;
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist =  new int[MAX];
        check = new boolean[MAX];
        paths = new int[MAX];

        q.add(A);
        dist[A] = 0;
        check[A] = true;
        paths[A] = A;


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
                    paths[back] = position;
                }
            }

            if (front < MAX) {
                if (!check[front]) {
                    dist[front] = dist[position] + 1;
                    check[front] = true;
                    q.add(front);
                    paths[front] = position;
                }
            }

            if (teleport < MAX) {
                if (!check[teleport]) {
                    dist[teleport] = dist[position] + 1;
                    check[teleport] = true;
                    q.add(teleport);
                    paths[teleport] = position;
                }
            }
        }

        System.out.println(dist[K]);
        print(paths, A, K);
    }

    static void print(int[] from, int n, int m) {
        if (n != m) {
            print(from, n, from[m]);
        }
        System.out.print(m + " ");
    }
}
