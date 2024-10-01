package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759 {
    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static int L;
    private static int C;
    private static char[] arr;
    private static char[] result;
    private static final StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        var st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st2.nextToken().charAt(0);
        }
        var start = 0;
        var depth = 0;
        result = new char[L];
        Arrays.sort(arr);


        go(start, depth);
        System.out.println(str);
    }

    private static void go(int start, int depth) {
        if (L == depth) {
            if (isValid(result)) {
                for (int i = 0; i < L; i++) {
                    str.append(result[i]);
                }
                str.append("\n");
            }

            return;
        }

        for (int i = start; i < C; i++) {
            var current = arr[i];
            result[depth] = current;
            go(i + 1, depth + 1);
        }
    }

    public static boolean isValid(char[] result) {
        int mo = 0;
        int ja = 0;

        for (char x : result) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
