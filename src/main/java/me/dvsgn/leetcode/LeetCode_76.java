package me.dvsgn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76 {
    public static void main(String[] args) {
        Solution_leet_76 s = new Solution_leet_76();

        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution_leet_76 {
    public String minWindow(String s, String t) {
        // result == 윈도우의 길이
        // 구해야하는 것: t가 포함된 윈도우의 최소 길이
        // l, r로 윈도우 설정, r의 시작 지점은 t.length() - 1 부터 하는게 효율적일 듯?
        // -> 이건 잘못된 가정인듯.. 그 알파벳 갯수 배열 카운팅 해줘야함 ㅠ
        // 만약에 윈도우 사이에 t가 다 포함되어 있으면 min 변수에 r - l + 1과 현재 min과 경쟁
        // 만약 현재 min이 t랑 length가 같다면 리턴
        // 현재 윈도우 내에 적어도 1개이상 t 랑 동일한게 있는지 체크하려면 이전에 썻던 방식처럼 26길이의 arr과 비교
        // 만약 다 포함한다 하더라도 더 짧은걸 찾기 위해 l-- 시키기
        // 윈도우 내에 t가 다 포함되지 않는다면 r++

        var result = "";
        var l = 0;
        var r = 0;
        var min = Integer.MAX_VALUE;
        var sHashMap = new HashMap<Character, Integer>();
        var tHashMap = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            tHashMap.put(t.charAt(i), tHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }


        while (l <= r) {
            if (r < s.length()) {
                sHashMap.put(s.charAt(r), sHashMap.getOrDefault(s.charAt(r), 0) + 1);
            }

            var isValid = true;
            for (Map.Entry<Character, Integer> entry : tHashMap.entrySet()) {
                if (sHashMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                if (min > r - l + 1) {
                    min = r - l + 1;

                    result = s.substring(l, r + 1);
                }
                sHashMap.put(s.charAt(l), sHashMap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            if (r < s.length() - 1) {
                r++;
            }
        }

        return result;
    }
}