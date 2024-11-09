package me.dvsgn.programmers;

public class DevSisters_Sol {
    public static void main(String[] args) {
        Solution_devsis sol = new Solution_devsis();

        System.out.println(sol.solution(8, new int[][]{{3, 12, 16}, {8, 2, 12}, {1, 14, 15}}));
    }
}

class Solution_devsis {
    public boolean solution(int capacity, int[][] routes) {
        boolean answer = true;

        int[] distance = new int[1001];
        for (int i = 0; i < routes.length; i++) {
            for (int j = routes[i][1]; j <= routes[i][2]; j++) {
                distance[j] += routes[i][0];
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > capacity) {
                return false;
            }
        }
        return answer;
    }
}