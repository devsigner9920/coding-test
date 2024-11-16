package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4574 {
    private static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            var dominoCount = Integer.parseInt(br.readLine());
            if (dominoCount == 0) {
                break;
            }
            sudoku = new int[9][9];
            for (int i = 0; i < dominoCount; i++) {
                st = new StringTokenizer(br.readLine());
                var a = st.nextToken();
                var aPos = st.nextToken();
                var aRow = aPos.charAt(0) - 'A';
                var aCol = Character.getNumericValue(aPos.charAt(1));

                var b = st.nextToken();
                var bPos = st.nextToken();
            }
        }

    }
}
