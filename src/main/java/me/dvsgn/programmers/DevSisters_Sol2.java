package me.dvsgn.programmers;

import java.util.*;

public class DevSisters_Sol2 {
    private static int max = 0;
    private static int pouchCount = 0;
    private static int[] freqs = new int[5];
    public int solution(String[] pouches) {
        int a = 0;
        if ((a & 2) == 3) {

        }
        List<String> saved = new ArrayList<>();
        bruteforce(pouches, saved, 0);
        return pouchCount;
    }

    public void bruteforce(String[] pouches, List<String> saved, int depth) {
        if (depth == pouches.length) {
            int[] freqs = new int[5]; // freqs 배열을 필요할 때만 새로 생성
            int maxFreq = 0;
            int totalChar = 0;

            // saved 리스트에 있는 각 문자열의 빈도를 바로 freqs에 업데이트
            for (String s : saved) {
                for (char c  : s.toCharArray()) {
                    int index = c - 'a';
                    freqs[index]++;
                    maxFreq = Math.max(maxFreq, freqs[index]); // 빈도 업데이트와 동시에 maxFreq 확인
                    totalChar++;
                }
            }

            int remain = totalChar - maxFreq;

            if (maxFreq > remain && max < maxFreq) {
                pouchCount = saved.size();
                max = maxFreq;
            }

            return;
        }
        // 젤리를 선택했을 때
        saved.add(pouches[depth]);
        bruteforce(pouches, saved, depth + 1);
        // 젤리를 선택 안했을 때
        saved.remove(saved.size() - 1);
        bruteforce(pouches, saved, depth + 1);
    }
}