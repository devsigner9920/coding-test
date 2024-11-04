package me.dvsgn.leetcode;

/*
    Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

    Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

    A full binary tree is a binary tree where each node has exactly 0 or 2 children.
*/

/*
Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]

n = 4
Output : [[]]

짝수일 경우 풀 바이너리 트리를 설정할수 없음

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jju_Test02 {
    public static void main(String[] args) {
        Solution_jju solution = new Solution_jju();
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_jju {


    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) return List.of(new TreeNode(0));
        if (n % 2 == 0) return new ArrayList<>();

        //시작노드만들고
        //1. 리프노드를 다 둘것인지 2. 안둘것인지 (0 or 2)
        List<TreeNode> list = new ArrayList<>();
        TreeNode[] memo = new TreeNode[21];
        memo[0] = new TreeNode();
        memo[1] = new TreeNode(0);
        memo[2] =

        makeTree(n, new TreeNode(0), list);

        return List.of(new TreeNode(0));
    }

    public TreeNode makeTree(int n, TreeNode curr, List<TreeNode> list){
        if(n == 0){
            list.add(curr);
        }
        n--;
        curr.left = makeTree(n, curr, list);

        return new TreeNode(0);

    }
}