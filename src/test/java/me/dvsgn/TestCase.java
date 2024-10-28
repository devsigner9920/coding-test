package me.dvsgn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;


public class TestCase {
    private static long before;

    @BeforeEach
    public void before() {
        before = System.currentTimeMillis();
    }

    @AfterEach
    public void after() {
        var after = System.currentTimeMillis();

        System.out.println((after - before) + "ms");
    }

    @Test
    public void test() {
        var prices = new int[]{7,6,4,3,1};

        var minPrice = prices[0];
        var maxPrice = 0;

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }

            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
        }
    }

    @Test
    public void test2() {
        var s = "abcabcbb";

        // 구간을 설정한다.
        // 2부터 s.length() - 1 까지 진행 한다.
        // 그 구간에 잘린 문자가 안에 중복이 있음 다음 이터레이션을 돌린다.
        // 최대값 비교한다.

        var left = 0;
        var maxLength = 0;
        var set = new HashSet<Character>();

        for (int right = 0; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            // set 에 right 번째 문자가 계속 존재한다면 loop를 돌아 left 를 ++ 시킨다.
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // set에 right 번째를 저장시킨다.
            set.add(currentChar);
            // maxLength 와 현재 포지션을 비교해서 max값 세팅한다.
            maxLength = Math.max(maxLength, right - left + 1);
        }
    }
}
