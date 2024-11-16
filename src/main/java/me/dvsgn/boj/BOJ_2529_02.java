package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2529_02 {
    private static String[] strings;
    private static String max = "0";
    private static String min = "9999999999";
    private static boolean[] check = new boolean[10];

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());
        strings = br.readLine().split(" ");

        bruteforce(0, n, new int[n + 1]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void bruteforce(int depth, int n, int[] result) {
        if (depth == n + 1) {
            var sb = new StringBuffer();
            for (int i : result) {
                sb.append(i);
            }
            var val = sb.toString();
            if (Long.parseLong(val) > Long.parseLong(max)) {
                max = val;
            }

            if (Long.parseLong(val) < Long.parseLong(min)) {
                min = val;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                check[i] = true;
                result[depth] = i;
                if (depth == 0) {
                    bruteforce(depth + 1, n, result);
                } else {
                    switch (strings[depth - 1]) {
                        case "<":
                            if (result[depth - 1] < result[depth]) {
                                bruteforce(depth + 1, n, result);
                            }
                            break;
                        case ">":
                            if (result[depth - 1] > result[depth]) {
                                bruteforce(depth + 1, n, result);
                            }
                            break;
                    }
                }
                check[i] = false;
            }
        }
    }
}
