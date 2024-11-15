package me.dvsgn.test;

import java.util.*;
import java.util.stream.Collectors;

public class Jju_zzbil {
    public static void main(String[] args) {
        int n = 5;
        int[] cost = {4, 3, 9, 3, 1};
        int k = 2;

        System.out.println(getMinimumCost(Arrays.stream(cost).boxed().toList(), 2));
    }

    public static long getMinimumCost(List<Integer> cost, int k) {
        int n = cost.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);

        for (int i = 1; i <= n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            dp[i] = dp[deque.peekFirst()] + cost.get(i - 1);

            while (!deque.isEmpty() && dp[i] <= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n];
    }

}
