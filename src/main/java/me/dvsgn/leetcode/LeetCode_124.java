package me.dvsgn.leetcode;

import java.util.Map;
import java.util.*;

public class LeetCode_124 {
    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {
        int n = parent.size();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            int p = parent.get(i);
            if (p == -1) {
                root = i;
            } else {
                tree.get(p).add(i);
            }
        }
        int[] maxSum = new int[] { Integer.MIN_VALUE };
        dfs(root, values, tree, maxSum);
        return maxSum[0];
    }

    private static int dfs(int node, List<Integer> values, Map<Integer, List<Integer>> tree, int[] maxSum) {
        int maxChildSum = 0;
        for (int child : tree.get(node)) {
            int childSum = dfs(child, values, tree, maxSum);
            if (childSum > maxChildSum) {
                maxChildSum = childSum;
            }
        }
        int currentSum = values.get(node);
        if (maxChildSum > 0) {
            currentSum += maxChildSum;
        }
        if (currentSum > maxSum[0]) {
            maxSum[0] = currentSum;
        }
        return currentSum;
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
class Solution_leet_124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);

        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
