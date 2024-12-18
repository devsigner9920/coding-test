package me.dvsgn.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NeTest {
    public static void main(String[] args) {

    }
}

class SolutionNe {
    public void func() {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        while (!deque.isEmpty()) {
            deque.poll();
            deque.pop();
        }
    }
}
