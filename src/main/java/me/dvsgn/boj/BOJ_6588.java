package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6588 {
    public static void main(String[] args) throws IOException {
        // 1_000_000 이하 소수 구하기
        var isPrimes = getIsPrimes();

        var br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                return;
            }
            var result = "";
            for (int i = 3; i <= num / 2; i += 2) {
                if (!isPrimes[i]) {
                    continue;
                }

                var target = num - i;

                if (isPrimes[target]) {
                    result = num + " = " + i + " + " + target;
                    break;
                }
            }

            if (result.isEmpty()) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.println(result);
            }
        }
    }


    private static boolean[] getIsPrimes() {
        var isPrime = new boolean[1_000_001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= 1000; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
