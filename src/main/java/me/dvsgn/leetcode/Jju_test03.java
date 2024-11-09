package me.dvsgn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jju_test03 {
    public static void main(String[] args) {
        Solution_test03 sol = new Solution_test03();

        System.out.println(sol.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
}

/*
    846. Hand of Straights
    Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

    Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.



    Example 1:
    Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
    Output: true
    Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]


    Example 2:
    Input: hand = [1,2,3,4,5], groupSize = 4
    Output: false
    Explanation: Alice's hand can not be rearranged into groups of 4.

    Example 3:
    Input: hand = [1,2,3,6,2,3,4,7,8,5], groupSize = 2
    Explanation : [1,2] [2,3] [3,4] [5,6] [7,8]
    Output : true


    1 <= hand.length <= 104
    1
    1 <= groupSize <= hand.length
*/

class Solution_test03 {

    //hand sort
    //hand length/group => 한 그룹에 몇개, 딱떨어지는 숫자가 아니면 false

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize > 0) return false;
        Arrays.sort(hand); //1, 2, 2, 3, 3, 4, 6, 7, 8
        int totalGroup = len/groupSize;
        boolean[] visited = new boolean[hand.length];

        for (int i = 0; i < totalGroup; i++) {
            int j = 0;
            while (visited[j]) j++;
            visited[j] = true;
            if (!backtracking(hand, visited, 1, groupSize, hand[j])) {
                return false;
            }
        }
        return true;
    }

    public boolean backtracking(int[] hand, boolean[] visited, int depth, int groupSize, int prev){
        if (groupSize == depth) {
            return true;
        }

        for (int i = 0; i < hand.length; i++) {
            if (visited[i]) continue;

            if (prev + 1 == hand[i]) {
                visited[i] = true;
                return backtracking(hand, visited, depth + 1, groupSize, hand[i]);
            }
        }

        return false;
    }

//    public boolean backtracking(int[] hand, boolean[] visited, int index, int groupSize, int totalGroup, int curr){
    public boolean backtracking(int[] hand, boolean[] visited, int index, int groupSize, int totalGroup, List<Integer> curr){
        if(curr.size() == groupSize){
            totalGroup--;
        }
        if(totalGroup == 0) {
            return true;
        }

        for(int i = index; i < hand.length; i++){
            if (visited[i]) continue;
            if (!visited[i]){
                curr.add(hand[i]);
                visited[i] = true;
                backtracking(hand, visited, i+1, groupSize, totalGroup, curr);


            }

        }

        return false;
    }
}

