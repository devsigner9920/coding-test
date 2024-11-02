package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20327 {
    private static int[][] S;
    // 배열 길이 제곱근 1<= N <= 7
    // 2 * 2부터 약 128 * 128까지 배열이 생성됨
    private static int N;

    // 수행해야할 커맨드 수
    private static int R;

    public static void main(String[] args) throws IOException {
        // N은 2^N 으로 2차원 배열 길이를 설정한다.
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        var pow = (int) Math.pow(2, N);
        // l 이라는 연산을 위한 구획 설정용 변수가 매 커맨드마다 들어온다.
        S = new int[pow][pow];

        // S 원소 채우기
        for (int i = 0; i < pow; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            var command = st.nextToken();
            var l = Integer.parseInt(st.nextToken());

            var subArrLength = (int) Math.pow(2, l);

            createSubArr(subArrLength, command);
        }
    }

    private static void createSubArr(int subArrLength, String command) {
        switch (command) {
            case "1":
                one(subArrLength);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
        }
    }

    private static void one(int subArrLength) {
        int nextToken;
        for (int i = 0; i < S.length / subArrLength; i++) {
            if (i % 2 == 0) {
                nextToken = 0;
            } else {
                nextToken = 1;
            }
            for (int j = 0; j < S.length / subArrLength; j++) {
                if (nextToken == 0) {
                    nextToken = 1;
                    continue;
                } else {
                    nextToken = 0;
                }
                System.out.println("i: " + i + " j: " + j);
            }
        }
    }
}
