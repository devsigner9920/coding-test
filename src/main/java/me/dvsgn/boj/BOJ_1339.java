package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BOJ_1339 {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // 알파벳 최대 10개
        // 숫자도 최대 0 ~ 9까지

        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var set = new HashSet<Character>();
        var strings = new String[n];
        for (int i = 0; i < n; i++) {
            var str = br.readLine();
            strings[i] = str;
            for (char c : str.toCharArray()) {
                set.add(c);
            }
        }

        // set 개수만큼 넣어주기?
        bf(new ArrayList<>(set), strings, 0, new boolean[10], new int[26]);
        System.out.println(max);
    }

    private static void bf(List<Character> list, String[] strings, int depth, boolean[] check, int[] numCount) {
        if (list.size() == depth) {
            var ints = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                StringBuilder temp = new StringBuilder();
                for (char c : strings[i].toCharArray()) {
                    temp.append(numCount[c - 'A']);
                }
                ints[i] = Integer.parseInt(temp.toString());
            }
            max = Math.max(Arrays.stream(ints).sum(), max);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                check[i] = true;
                numCount[list.get(depth) - 'A'] = i;
                bf(list, strings, depth + 1, check, numCount);
                check[i] = false;
            }
        }
    }
}
