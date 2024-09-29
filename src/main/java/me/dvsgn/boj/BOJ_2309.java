package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        var sum = Arrays.stream(arr).sum();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                var a = arr[i];
                var b = arr[j];

                if (sum - a - b == 100) {
                    Arrays.sort(arr);
                    for (int k = 0; k < arr.length; k++) {
                        var result = arr[k];
                        if (result == a || result == b) {
                            continue;
                        }
                        System.out.println(result);
                    }
                    return;
                }
            }
        }
    }
}
