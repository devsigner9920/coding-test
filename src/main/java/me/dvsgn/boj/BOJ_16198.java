package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16198 {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());
        var arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bf(arr, 1, 0);
        System.out.println(max);
    }

    private static void bf(int[] arr, int idx, int result) {
        if (arr.length == 2) {
            max = Math.max(result, max);
            return;
        }
        if (idx == arr.length - 1) return;

        var newArr = new int[arr.length - 1];
        var cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) continue;
            newArr[cnt] = arr[i];
            cnt++;
        }
        bf(newArr, 1, result + (arr[idx - 1] * arr[idx + 1]));
        bf(arr, idx + 1, result);
    }
}
