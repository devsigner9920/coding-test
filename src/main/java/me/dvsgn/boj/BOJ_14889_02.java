package me.dvsgn.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_14889_02 {
    static int[][] s;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        System.out.println(go(0, first, second));
    }

    static int go(int index, List<Integer> first, List<Integer> second) {
        if (index == n) {
            if (first.size() != n / 2)  return -1;
            if (second.size() != n / 2)  return -1;

            int t1 = 0;
            int t2 = 0;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[first.get(i)][first.get(j)];
                }
            }

            int diff = Math.abs(t1 - t2);
            return diff;
        }

        int ans = -1;
        first.add(index);
        int t1 = go(index + 1, first, second);
        if (ans == -1 || (t1 != -1 && ans > t1)) {
            ans = t1;
        }
        first.remove(first.size() - 1);

        second.add(index);
        int t2 = go(index + 1, second, first);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2;
        }
        second.remove(second.size() - 1);

        return ans;
    }
}
