package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_16935 {
    private static int N;
    private static int M;
    private static int C;
    private static int[] commands;
    private static int[][] S;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int command : commands) {
            switch (command) {
                case 1:
                    first();
                    break;
                case 2:
                    second();
                    break;
                case 3:
                    third();
                    break;
                case 4:
                    fourth();
                    break;
                case 5:
                    fifth();
                    break;
                case 6:
                    sixth();
                    break;
            }
        }
    }

    private static void first() {
        var sb = new StringBuffer();

        for (int i = N - 1; i >= 0; i--) {
            sb.append(Arrays.stream(S[i])
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ", "", "")));
            if (i != 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void second() {
        var sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                sb.append(S[i][j]);

                if (j != 0) {
                    sb.append(" ");
                }
            }
            if (i != N - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void third() {
        var sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                sb.append(S[j][i]);

                if (j != 0) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void fourth() {
        var sb = new StringBuffer();

        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                sb.append(S[j][i]);

                if (j != N - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void fifth() {
        var sb = new StringBuffer();
        var nRange = N / 2;
        var mRange = M / 2;
        int[][] newArr = new int[N][M];

        for (int i = 0; i < nRange; i++) {
            for (int j = 0; j < mRange; j++) {
                newArr[i][j + mRange] = S[i][j];
                newArr[i + nRange][j + mRange] = newArr[i][j + mRange];
                newArr[i + nRange][j] = newArr[i + nRange][j + mRange];
                newArr[i][j] = S[i + nRange][j];

            }
        }

        for (int[] ints : newArr) {
            sb.append(Arrays.stream(ints)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ", "", "")));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void sixth() {
        var sb = new StringBuffer();
        var nRange = N / 2;
        var mRange = M / 2;
        int[][] newArr = new int[N][M];

        for (int i = 0; i < nRange; i++) {
            for (int j = 0; j < mRange; j++) {
                newArr[i + nRange][j] = S[i][j];
                newArr[i][j] = S[i][j + mRange];
                newArr[i][j + mRange] = S[i + nRange][j + mRange];
                newArr[i + nRange][j + mRange] = S[i + nRange][j];

            }
        }

        for (int[] ints : newArr) {
            sb.append(Arrays.stream(ints)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ", "", "")));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
