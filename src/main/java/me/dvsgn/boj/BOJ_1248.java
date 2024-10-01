package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248 {
    private static int N = 21;
    private static int[] numbers = new int[N];
    private static int M;
    private static int[] result;
    private static String[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        result = new int[M];
        for (int i = -10; i < N - 10; i++) {
            numbers[i + 10] = i;
        }
        S = new String[M][M];
        var temp = br.readLine().split("");
        var tempCount = 0;

        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                S[i][j] = temp[tempCount];
                tempCount++;
            }
        }

        go(0, result);
    }

    private static void go(int depth, int[] result) {
        if (depth == M) {
            var sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);

                if (i != result.length - 1) {
                    sb.append(" ");
                }
            }

            System.out.println(sb);
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            result[depth] = numbers[i];
            var a = isOk(depth, result);
            if (a) {
                go(depth + 1, result);
            }
        }
    }

    private static boolean isOk(int depth, int[] result) {
        for (int j = 0; j <= depth; j++) {
            var sum = 0;
            for (int k = j; k <= depth; k++) {
                sum += result[k];
                if (S[j][k].equals("+")) {
                    if (!(sum > 0)) return false;
                }

                if (S[j][k].equals("-")) {
                    if (!(sum < 0)) return false;
                }

                if (S[j][k].equals("0")) {
                    if (!(sum == 0)) return false;
                }
            }
        }

        return true;
    }
}
