package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var min = Integer.parseInt(st.nextToken());
        var max = Integer.parseInt(st.nextToken());

        var isPrimes = new boolean[max + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = isPrimes[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!isPrimes[i]) {
                continue;
            }

            for (int j = i * i; j < isPrimes.length; j += i) {
                isPrimes[j] = false;
            }
        }

        for (int i = min; i <= max; i++) {
            if (isPrimes[i]) {
                System.out.println(i);
            }
        }
    }
}
