package me.dvsgn.leetcode;

import java.util.*;
import java.util.Map;

public class Jju_test05 {
    public static void main(String[] args) {
        Solution_test05 sol = new Solution_test05();

    }
}

/*
    Longest Repeating Character Replacement

    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.

    You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.



    Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    AAAA => 4


    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.

    AA"B"A => 4

    input s = "ACBACAABB", k = 1
    AAAA
    right index 5 k => 0

    A: 3, B: 1 , C: 1 => 5 - 3(A) = 2
    s = ACBACAABB k = 1
        l
        r

    4

    k 를 쓸 수 없는케이스에서 freq[l - 'A']--; l++;
    k 를 쓸 수 있을때 r++;


*/
class Solution_test05 {

//    public int characterReplacement(String s, int k) {
//        int max = 1;
//        if (s.length() == 1) return max;
//        int left = 0;
//        int right = 1;
//        int[] freq = new int[26];
//        freq[s.charAt(left)-'A']++;
//        while(right < s.length()){
//            max = Math.max(max, right-left);
//            if(freq[s.charAt(right)-'A'] > 0){
//                freq[s.charAt(right)-'A']++;
//                right++;
//            }else{
//                freq[s.charAt(right)-'A']++;
//                k--;
//                if(k < 0){
//                    freq[s.charAt(left)-'A']--;
//                    left++;
//                    k++;
//                }
//            }
//        }
//
//        return max;
//    }

    public int characterReplacement(String s, int k) {
        // 대문자 A - Z 까지 26자이므로 각각 문자를 카운팅하는 배열
        var arr = new int[26];
        var result = 0;

        // 현재 윈도우 안에서 제일 큰 수!!!!!
        var max = 0;

        // 슬라이딩 윈도우가 l = 0; r = 0 부터 시작함 겹친 상태서 시작
        var l = 0;

        for (int r = 0; r < s.length(); r++) {
            // 각각의 char가 s 안에 몇개나 들어있는지 카운팅 한다.
            // char A 부터 시작하니까 A - A == 0 이므로 0번째부터 A-Z 카운트 기록
            arr[s.charAt(r) - 'A']++;

            // 현재 위치의 알파벳의 갯수와 max값과 비교한다.
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            // (현재 윈도우 크기 - 현재 윈도우안에서 제일 큰 수의 갯수) 가 k 보다 크다면
            // 현재 윈도우의 모든 불일치 수들을 k개 만큼 바꿔줄 수 없으니 l을 증가시켜 윈도우를 축소시킨다.
            // 그와 동시에 l이 커지니까 기존 l 위치에 있던 알파벳 카운트를 -1 시킨다.
            if (r - l + 1 - max > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }

}
