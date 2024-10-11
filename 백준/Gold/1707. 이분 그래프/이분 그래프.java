import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int V;
    private static int E;
    private static int[] check;
    private static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        var testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            check = new int[V + 1];
            graph = new ArrayList[V + 1];
            for (int j = 1; j < graph.length; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                var n1 = Integer.parseInt(st.nextToken());
                var n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            var ok = true;
            for (int j = 1; j <= V; j++) {
                if (check[j] == 0) {
                    if (!isBipartiteGraph(j, 1)) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartiteGraph(int start, int color) {
        check[start] = color;
        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);

            if (check[next] == 0) {
                if (isBipartiteGraph(next, 3 - color) == false) {
                    return false;
                }
            } else if (check[next] == check[start]) {
                return false;
            }
        }

        return true;
    }
}
