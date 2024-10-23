package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499 {
    private static int N;
    private static int M;
    private static int x;
    private static int y;
    private static int[][] S;
    private static int[] dice = new int[]{0, 0, 0, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        S = new int[N][M];

        for (int i = 0; i < S.length; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        var commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int command : commands) {
            switch(command) {
                case 1:
                    east();
                    break;
                case 2:
                    west();
                    break;
                case 3:
                    north();
                    break;
                case 4:
                    south();
                    break;
            }
        }

    }

    // 북쪽
    private static void north() {
        if (x -1 < 0) {
            return;
        }
        var temp = dice[1];
//        1 -> 2
//        5 -> 1
        dice[1] = dice[5];
//        6 -> 5
        dice[5] = dice[6];
//        2 -> 6 바닥이 되는거
        dice[6] = dice[2];
        dice[2] = temp;

        x -= 1;
        commonRule();
    }

    // 남쪽
    private static void south() {
        if (x + 1 == N) {
            return;
        }
        var temp = dice[1];
//        2 -> 1
        dice[1] = dice[2];
//        6 -> 2
        dice[2] = dice[6];
//        5 -> 6
        dice[6] = dice[5];
//        1 -> 5
        dice[5] = temp;

        x += 1;
        commonRule();
    }

    // 서쪽
    private static void west() {
        if (y - 1 < 0) {
            return;
        }
        var temp = dice[1];

        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = temp;

        y -= 1;
        commonRule();
    }

    // 동쪽
    private static void east() {
        if (y + 1 == M) {
            return;
        }
        var temp = dice[1];

        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = temp;

        y += 1;
        commonRule();
    }

    private static void commonRule() {
        if (S[x][y] == 0) {
            S[x][y] = dice[6];
        } else {
            dice[6] = S[x][y];
            S[x][y] = 0;
        }

        System.out.println(dice[1]);
    }
}
