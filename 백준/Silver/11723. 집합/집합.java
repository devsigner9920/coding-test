import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static boolean[] S = new boolean[21];
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            var readLine = br.readLine().split(" ");
            var command = readLine[0];
            var x = 0;
            if (!(command.equals("all") || command.equals("empty"))) {
                x = Integer.parseInt(readLine[1]);
            }

            switch (command) {
                case "add":
                    add(x);
                    break;
                case "remove":
                    remove(x);
                    break;
                case "check":
                    check(x);
                    break;
                case "toggle":
                    toggle(x);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void empty() {
        Arrays.fill(S, false);
    }

    private static void all() {
        for (int i = 1; i <= 20; i++) {
            S[i] = true;
        }
    }

    private static void toggle(int x) {
        S[x] = !S[x];
    }

    private static void check(int x) {
        if (S[x]) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static void remove(int x) {
        S[x] = false;
    }

    private static void add(int x) {
        S[x] = true;
    }
}
