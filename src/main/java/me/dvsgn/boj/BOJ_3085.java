package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        var result = 0;

        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies[i].length; j++) {
                for (int k = j; k < candies[i].length; k++) {

                }

                // 오른쪽 고르기
                if (j + 1 < candies[i].length) {
                    var currentResult = getRightSwitchingResult(candies, i, j);
                    result = Math.max(result, currentResult);
                }

                // 아래 고르기
                if (i + 1 < candies.length) {
                    var currentResult = getDownSwitchingResult(candies, i, j);
                    result = Math.max(result, currentResult);
                }
            }
        }

        System.out.println(result);
    }

    private static int getDownSwitchingResult(char[][] candies, int i, int j) {
        var switchedCandy = candies[i + 1][j];
        var currentResult = 1;

        // 왼쪽
        for (int k = j - 1; k >= 0; k--) {
            if (switchedCandy == candies[i][k]) {
                currentResult++;
            } else { break; }
        }
        // 오른쪽
        for (int k = j + 1; k < candies[i].length; k++) {
            if (switchedCandy == candies[i][k]) {
                currentResult++;
            } else { break; }
        }
        return currentResult;
    }

    private static int getRightSwitchingResult(char[][] candies, int i, int j) {
        var switchedCandy = candies[i][j + 1];
        var currentResult = 1;

        // 위
        for (int k = i - 1; k >= 0; k--) {
            if (switchedCandy == candies[k][j]) {
                currentResult++;
            } else { break; }
        }
        for (int k = i + 1; k < candies.length; k++) {
            if (switchedCandy == candies[k][j]) {
                currentResult++;
            } else { break; }
        }
        return currentResult;
    }
}
