package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16197 {
    private static int n;
    private static int m;
    private static char[][] s;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
//    private static int[]
    private static boolean[][] check;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            var temp = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                s[i][j] = temp[j - 1];
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (i == 0 || i == s.length - 1) {
                Arrays.fill(s[i], 'x');
                continue;
            }
            for (int j = 0; j < s[i].length; j++) {
                if (j == 0 || j == s[i].length - 1) {
                    s[i][j] = 'x';
                }
            }
        }
        check = new boolean[s.length][s[0].length];
        var coins = new Coin_16197[2];
        var coinIndex = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (s[i][j] == 'o') {
                    coins[coinIndex] = new Coin_16197(i, j);
                    coinIndex++;
                }
            }
        }

        System.out.println(Arrays.deepToString(s));

        bf(coins, 0, 0, 0);
    }

    public static void bf(Coin_16197[] coins, int x, int y, int count) {
        if (count == 11) {

            return;
        }
        var coin1 = coins[0];
        var coin2 = coins[1];

        coin1.x += x;
        coin1.y += y;
        coin2.x += x;
        coin2.y += y;


        for (int i = 0; i < 4; i++) {
            bf(coins, dx[i], dy[i], count++);
        }
    }
}

class Coin_16197 {
    int x;
    int y;

    public Coin_16197(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
