package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10973 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        var isEarlyEnd = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                isEarlyEnd = false;
                break;
            }
        }

        if (isEarlyEnd) {
            System.out.println(-1);
            return;
        }

        var sortStart = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                for (int j = N - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        break;
                    }
                }
                sortStart = i + 1;
                break;
            }
        }
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < sortStart; i++) {
            a.add(arr[i]);
        }
        for (int i = N - 1; i >= sortStart; i--) {
            a.add(arr[i]);
        }

        getOutput(a);
    }

    private static void getOutput(List<Integer> result) {
        var sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result.get(i));
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
