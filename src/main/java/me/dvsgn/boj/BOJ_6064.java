package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var testCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCase; i++) {
            run(br);
        }
    }

    private static void run(BufferedReader br) throws IOException {
        var st = new StringTokenizer(br.readLine(), " ");

        var M = Integer.parseInt(st.nextToken());
        var N = Integer.parseInt(st.nextToken());
        var x = Integer.parseInt(st.nextToken());
        var y = Integer.parseInt(st.nextToken());

        var calendar = new Calendar(M, N, x, y);

        while (!calendar.isMatch()) {
            calendar.increase();
        }

        System.out.println(calendar.getYear());
    }
}

class Calendar {
    private int M;
    private int N;
    private int x;
    private int y;
    private boolean isValid = false;
    private int year;
    private int currentX;
    private int currentY;

    public Calendar(int m, int n, int x, int y) {
        this.M = m;
        this.N = n;
        this.x = x;
        this.y = y;
        year = 1;
        this.currentX = 1;
        this.currentY = 1;
    }

    public boolean isMatch() {
        if (x == currentX && y == currentY) {
            isValid = true;
            return true;
        }

        return M == currentX && N == currentY;
    }

    public void increase() {
        currentX++;
        currentY++;

        if (currentX > M) {
            currentX = 1;
        }

        if (currentY > N) {
            currentY = 1;
        }
        year++;
    }

    public int getYear() {
        if (isValid) {
            return year;
        }

        return -1;
    }
}