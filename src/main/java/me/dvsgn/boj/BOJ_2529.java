package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
    private static int N = 10;
    private static int signCount;
    private static char[] signs;
    private static boolean[] visit = new boolean[N];
    private static String min = "9999999999";
    private static String max = "0000000000";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        signCount = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine(), " ");
        signs = new char[signCount];
        for (int i = 0; i < signCount; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        go(0, "");
        System.out.println(max);
        System.out.println(min);
    }

    static void go(int depth, String str) {
        if (depth == signCount + 1) {
            if (isOk(str)) {
                if (Long.parseLong(str) > Long.parseLong(max)) {
                    max = str;
                }

                if (Long.parseLong(str) < Long.parseLong(min)) {
                    min = str;
                }
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
               visit[i] = true;
               go(depth + 1, str + i);
               visit[i] = false;
            }
        }
    }

    private static boolean isOk(String str) {
        var arr = str.toCharArray();

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] == '<') {
                if (!(arr[i] < arr[i + 1])) {
                    return false;
                }
            }

            if (signs[i] == '>') {
                if (!(arr[i] > arr[i + 1])) {
                    return false;
                }
            }
        }

        return true;
    }
}
