package me.dvsgn.leetcode;

public class LeetCode_563 {
    public static void main(String[] args) {
        Solution_563 sol = new Solution_563();
        var temp = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        System.out.println(sol.findTilt(temp));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_563 {
    int result = 0;
    public int findTilt(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        var temp1 = dfs(node.left);
        var temp2 = dfs(node.right);
        result += Math.abs(temp1 - temp2);
        return temp1 + temp2 + node.val;
    }
}