package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_02 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            var k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            var lottos = new int[k];
            for (int i = 0; i < k; i++) {
                lottos[i] = Integer.parseInt(st.nextToken());
            }

            sol(lottos);
        }
    }

    private static void sol(int[] lottos) {
        var check = new boolean[lottos.length];
        var ints = new int[6];
        bf(lottos, check, 0, 0, ints);
    }

    private static void bf(int[] lottos, boolean[] check, int start, int depth, int[] ints) {
        if (depth == 6) {
            for (int i = ints.length - 2; i >= 0; i--) {
                if (ints[i] > ints[i + 1]) {
                    return;
                }
            }
            var br = new StringBuffer();
            for (int i = 0; i < ints.length; i++) {
                br.append(ints[i]);
                if (i != ints.length - 1) {
                    br.append(" ");
                }
            }
            System.out.println(br);
            return;
        }

        for (int i = start; i < lottos.length; i++) {
            if (check[i]) continue;

            check[i] = true;
            ints[depth] = lottos[i];
            bf(lottos, check, start + 1, depth + 1, ints);
            check[i] = false;
        }
    }
}
