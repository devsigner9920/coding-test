import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static char[] op;
    private static long min = Integer.MAX_VALUE;
    private static long max = Integer.MIN_VALUE;
    private static List<String> set;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var st = new StringTokenizer(br.readLine());

        var plus = Integer.parseInt(st.nextToken());
        var minus = Integer.parseInt(st.nextToken());
        var multi = Integer.parseInt(st.nextToken());
        var div = Integer.parseInt(st.nextToken());
        op = new char[plus + minus + multi + div];
        set = new ArrayList<>();

        Arrays.fill(op, 0, plus, '+');
        Arrays.fill(op, plus, plus + minus, '-');
        Arrays.fill(op, plus + minus, plus + minus + multi, 'x');
        Arrays.fill(op, plus + minus + multi, plus + minus + multi + div, '%');

        // 모든 중복없는 조합
        bf(op, new boolean[op.length], 0, new char[op.length], n - 1);


        for (String s : set) {
            var num = arr[0];
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '+':
                        num += arr[i + 1];
                        break;
                    case '-':
                        num -= arr[i + 1];
                        break;
                    case 'x':
                        num *= arr[i + 1];
                        break;
                    case '%':
                        num /= arr[i + 1];
                        break;
                }
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(max);
        System.out.println(min);
    }

    private static void bf(char[] op, boolean[] check, int depth, char[] chars, int n) {
        if (n == depth) {
            set.add(new String(chars));
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (check[i]) continue;

            if (i > 0 && op[i] == op[i - 1] && !check[i - 1]) continue;

            chars[depth] = op[i];
            check[i] = true;
            bf(op, check, depth + 1, chars, n);
            check[i] = false;
        }
    }
}
