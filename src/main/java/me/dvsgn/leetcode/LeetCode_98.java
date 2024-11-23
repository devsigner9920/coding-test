package me.dvsgn.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode_98 {
    public static void main(String[] args) {
        Solution_leet_98 sol = new Solution_leet_98();
        sol.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
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
class Solution_leet_98 {
    public boolean isValidBST(TreeNode root) {
        var curElement = Integer.MIN_VALUE;
        var sortedList = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            sortedList.sort(Integer::compareTo);
            sortedList.add(root.val);
            if (root.val <= curElement) {
                return false;
            } else {
                curElement = root.val;
            }
            root = root.right;
        }

        return true;
    }
}