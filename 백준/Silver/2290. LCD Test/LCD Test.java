import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] lcd = new int[][]{
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var s = Integer.parseInt(st.nextToken());
        var n = st.nextToken().toCharArray();

        var sb = new StringBuffer();

        for (int i = 1; i < 6; i++) {
            if (i == 1 || i == 3 || i == 5) {
                for (char c : n) {
                    var num = Character.getNumericValue(c);
                    sb.append(" ");
                    if ((i == 1 && lcd[num][1] == 1) || (i == 3 && lcd[num][4] == 1) || (i == 5 && lcd[num][7] == 1)) {
                        sb.append("-".repeat(s));
                    } else {
                        sb.append(" ".repeat(s));
                    }
                    sb.append(" ");
                    sb.append(" ");
                }
                sb.append("\n");
            }

            if (i == 2 || i == 4) {
                for (int j = 0; j < s; j++) {
                    for (char c : n) {
                        var num = Character.getNumericValue(c);
                        if ((i == 2 && lcd[num][2] == 1) || (i == 4 && lcd[num][5] == 1)) {
                            sb.append("|");
                        } else {
                            sb.append(" ");
                        }
                        sb.append(" ".repeat(s));
                        if ((i == 2 && lcd[num][3] == 1) || (i == 4 && lcd[num][6] == 1)) {
                            sb.append("|");
                        } else {
                            sb.append(" ");
                        }
                        sb.append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
