package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var queue = new DeQueue();
        for (int i = 0; i < n; i++) {
            var command = br.readLine();

            var commandSplit = command.split(" ");
            switch (commandSplit[0]) {
                case "push_front":
                    queue.push_front(Integer.parseInt(commandSplit[1]));
                    break;
                case "push_back":
                    queue.push_back(Integer.parseInt(commandSplit[1]));
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.isEmpty();
                    break;
                case "pop_back":
                    queue.pop_back();
                    break;
                case "pop_front":
                    queue.pop_front();
                    break;
            }
        }
    }
}

class DeQueue {
    private final List<Integer> queue = new ArrayList<>();

    public void push_front(int x) {
        queue.add(0, x);
    }

    public void push_back(int x) {
        queue.add(x);
    }

    public void pop_back() {
        if (queue.isEmpty()) System.out.println(-1);
        else System.out.println(queue.remove(queue.size() - 1));
    }

    public void pop_front() {
        if (queue.isEmpty()) System.out.println(-1);
        else System.out.println(queue.remove(0));
    }

    public void size() {
        System.out.println(queue.size());
    }

    public void isEmpty() {
        if (queue.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public void front() {
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(0));
    }

    public void back() {
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(queue.size() - 1));
    }
}
