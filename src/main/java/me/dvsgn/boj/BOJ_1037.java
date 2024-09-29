package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        // 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
        // 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.

        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var arr = new long[n];
        var st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(Arrays.stream(arr).min().getAsLong() * Arrays.stream(arr).max().getAsLong());
    }
}
