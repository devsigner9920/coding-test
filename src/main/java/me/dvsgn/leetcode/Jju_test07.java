package me.dvsgn.leetcode;

/*
    Given the root of a binary tree, return the sum of values of its deepest leaves.

    Example 1:
    Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    Output: 15

    Example 2:
    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 19

    The number of nodes in the tree is in the range [1, 10^4].
    1 <= Node.val <= 100
*/

import java.util.LinkedList;
import java.util.Queue;

public class Jju_test07 {
    public static void main(String[] args) {

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
class Solution_test07 {

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            sum = 0;
            for(int i = 0; i < q.size(); i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return sum;
    }
}