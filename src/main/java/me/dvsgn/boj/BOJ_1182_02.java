package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_02 {
    private static int[] a;
    private static int s;
    private static int count;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bf(0, 0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void bf(int index, int sum) {
        if (index == a.length) {
            if (sum == s) {
                count++;
            }
            return;
        }

        bf(index + 1, sum + a[index]);
        bf(index + 1, sum);
    }
}
