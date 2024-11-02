package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6603_02 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // k 개의 숫자가 있을 때, 6개를 뽑아서 사전순으로 나열해서 모든 경우의 수를 구하는 것 -> 브루트포스!
        // 왜 더하고 빼는지??
        while (true) {
            st = new StringTokenizer(br.readLine());
            var k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            var lottos = new int[k];
            for (int i = 0; i < k; i++) {
                lottos[i] = Integer.parseInt(st.nextToken());
            }

            sol(lottos);
            System.out.println();
        }
    }

    private static void sol(int[] totalArray) {
        var lotto = new ArrayList<Integer>();
        bf(totalArray, lotto, 0, 0);
    }

    private static void bf(int[] totalArray, List<Integer> lotto, int index, int depth) {
        if (depth == 6) {
            for (Integer i : lotto) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if (index == totalArray.length) return;

        // 정답 배열에다가 현재 index의 정답을 넣는다.
        lotto.add(totalArray[index]);
        // index를 늘린다 1 -> 2 -> 3 ...
        bf(totalArray, lotto, index + 1, depth + 1);
        // 집어 넣었던 것들을 다시 원복시킨다.
        lotto.remove(lotto.size() - 1);
        // 뎁스 증가하지않고 다음 차례 index 부터 시작한다.
        bf(totalArray, lotto, index + 1, depth);
    }
}
