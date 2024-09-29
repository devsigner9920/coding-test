package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        var arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        var maxNumber = arr[arr.length - 1];
        var isPrime = new boolean[maxNumber + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(maxNumber); i++) {
            if(!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        var result = 0;
        for (int j : arr) {
            if (isPrime[j]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
