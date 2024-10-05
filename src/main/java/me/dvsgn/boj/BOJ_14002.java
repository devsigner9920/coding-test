package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002 {
    // 입력된 수열 저장
    private static int[] A = new int[10_000];
    private static int[] D = new int[10_000];
    private static int[] V = new int[10_000];

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        V[0] = -1;

        for (int i = 0; i < N; i++) {
            D[i] = 1;
            V[i] = -1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && D[i] < D[j] + 1) {
                    D[i] = D[j] + 1;
                    V[i] = j;
                }
            }
        }

        int temp = 0;
        int tempIdx = 0;
        for (int i = 0; i < N; i++) {
            if (temp < D[i]) {
                temp = D[i];
                tempIdx = i;
            }
        }

        var a= go(tempIdx).trim();
        System.out.println(temp);
        System.out.println(a);
    }

    private static String go(int n) {
        if (n == -1) {
            return "";
        }
        return go(V[n]) + " " + A[n];
    }
}
