import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int N;
    private static int M;
    private static int V;
    private static boolean[] check;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort(Integer::compareTo);
        }

        var result = new ArrayList<Integer>();
        dfs(V, 0, result);
        var result1 = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result1);
        Arrays.fill(check, false);
        result = new ArrayList<>();
        bfs(V, result);
        var result2 = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result2);
    }

    private static void bfs(int v, ArrayList<Integer> result) {
        var arr = new ArrayList<Integer>();
        arr.add(v);

        while (!arr.isEmpty()) {
            var current = arr.remove(0);
            if (check[current]) {
                continue;
            }

            arr.addAll(graph[current]);

            check[current] = true;
            result.add(current);
        }
    }

    private static void dfs(int v, int depth, ArrayList<Integer> result) {
        if (depth == N) {
            return;
        }

        check[v] = true;
        result.add(v);
        for (int index : graph[v]) {
            if (!check[index]) {
                dfs(index, depth + 1, result);
            }
        }
    }
}
