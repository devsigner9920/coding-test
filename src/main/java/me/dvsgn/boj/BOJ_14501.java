package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    private static int result;
    private static int N;
    private static int[] periods;
    private static int[] pays;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        periods = new int[N + 1];
        pays = new int[N + 1];
        var day = 1;
        var profit = 0;
        for (int i = 1; i <= N; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            periods[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        go(day, profit);
        System.out.println(result);
    }

    private static void go(int day, int profit) {
        if (day > N + 1) {
            return;
        }
        if (day == N + 1)  {
            result = Math.max(result, profit);
            return;
        }

        go(day + periods[day], profit + pays[day]);
        go(day + 1, profit);
    }
}
