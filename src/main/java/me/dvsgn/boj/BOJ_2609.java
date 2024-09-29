package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        var gcd = gcd(Math.max(a, b), Math.min(a, b));
        var lcm = lcm(Math.max(a, b), Math.min(a, b));
        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;

        return gcd(b, r);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
