package me.dvsgn.leetcode;

public class LeetCode_1925 {
    public static void main(String[] args) {
        Solution_1925 sol = new Solution_1925();
        System.out.println(sol.countTriples(10));
    }
}

class Solution_1925 {
    public int countTriples(int n) {
        var count = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i < j; i++) {
                var temp = j * j - i * i;
                if (temp + (i * i) == j * j) {
                    var temp2 = Math.sqrt(temp);
                    if (temp2 == (int) temp2) count++;
                }
            }
        }

        return count;
    }
}
