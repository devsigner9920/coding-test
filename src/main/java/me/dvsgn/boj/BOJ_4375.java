package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringJoiner;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var result = new StringJoiner(System.lineSeparator());

        String input;
        while ((input = br.readLine()) != null) {
            var n = Integer.parseInt(input);
            result.add(String.valueOf(answer(n)));
        }

        System.out.println(result);
    }

    private static int answer(int n) {
        BigInteger num = BigInteger.valueOf(11);
        while (true) {
            if (num.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
                return num.toString().length();
            }
            num = num.multiply(BigInteger.valueOf(10)).add(BigInteger.ONE);
        }
    }
}
