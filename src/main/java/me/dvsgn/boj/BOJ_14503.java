package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503 {
    private static int N;
    private static int M;
    private static int[][] S;
    // 0: 북, 1: 동, 2: 남, 3: 서
    private static int[] dx = new int[]{-1, 0, 1, 0};  // 북, 동, 남, 서에 따른 x 좌표 이동
    private static int[] dy = new int[]{0, 1, 0, -1};  // 북, 동, 남, 서에 따른 y 좌표 이동

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        var x = Integer.parseInt(st.nextToken());
        var y = Integer.parseInt(st.nextToken());
        var d = Integer.parseInt(st.nextToken());
        var robot = new Robot(x, y, d);
        S = new int[N][M];

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(robot.run(S, dx, dy));
    }
}

class Robot {
    private int x;
    private int y;
    private int d;
    private int count;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int run(int[][] s, int[] dx, int[] dy) {
        while (true) {
            // 현재 위치를 청소
            if (s[x][y] == 0) {
                count++;
                s[x][y] = 2; // 청소 완료
            }

            boolean isCleanable = false;
            // 네 방향 검사
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4; // 현재 방향에서 왼쪽으로 회전
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if (nx >= 0 && ny >= 0 && nx < s.length && ny < s[0].length && s[nx][ny] == 0) {
                    // 청소할 수 있는 곳 발견
                    x = nx;
                    y = ny;
                    d = nd;
                    isCleanable = true;
                    break;
                }
                d = nd; // 왼쪽으로 회전만 수행
            }

            if (!isCleanable) {
                // 후진
                int backX = x - dx[d];
                int backY = y - dy[d];

                if (backX < 0 || backY < 0 || backX >= s.length || backY >= s[0].length || s[backX][backY] == 1) {
                    // 후진할 수 없으면 종료
                    break;
                }

                x = backX;
                y = backY;
            }
        }

        return count;
    }
}
