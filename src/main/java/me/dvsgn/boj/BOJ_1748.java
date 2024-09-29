package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var num = Integer.parseInt(br.readLine());

        var tenPower = getTenPower(num);

        var result = 0L;
        for (int i = tenPower; i > 0; i--) {
            var pow = Math.pow(10, i - 1);
            if (i == tenPower) {
                result += (long) ((num - pow + 1) * i);
                continue;
            }
            result += (long) ((pow * 9) * i);
        }

        System.out.println(result);
    }

    private static int getTenPower(int num) {
        var tenPower = 0;

        while (num > 0) {
            num /= 10;
            tenPower++;
        }
        return tenPower;
    }
}
