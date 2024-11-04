package me.dvsgn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
*
Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent.
* If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.


*
*
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Input: root = [1]
Output: 0
* */
public class Jju_Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /*
    노드를 레벨별로 내려가면서 (큐를 이용)
    grandparent => 관점이 조상에서 본다면 현재레벨보다 + 2, 관점 리프면, 현재 레벨보다 -2
    Even value 만나면 리프노드 있는지 체크하고 추가
     */
    class LevelNode {
        TreeNode node;
        int level;

        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public boolean hasLeft() {
            return node.left != null;
        }

        public TreeNode getLeft() {
            return node.left;
        }

        public boolean hasRight() {
            return node.right != null;
        }

        public TreeNode getRight() {
            return node.right;
        }

    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        Queue<LevelNode> q = new LinkedList<>();
        int even = 0;
//        Map<Integer, >
        q.add(new LevelNode(root, 0));
        while (!q.isEmpty()) {
            LevelNode popped = q.poll();
            if (popped.hasLeft()) {
                q.add(new LevelNode(popped.getLeft(), popped.level + 1));
            }
            if (popped.hasRight()) {
                q.add(new LevelNode(popped.getRight(), popped.level + 1));
            }

            if (popped.node.val % 2 == 0) {
//                popped.node.left.left;
//                popped.node.left.right;
//                popped.node.left.right;
//                popped.node.left.right;
            }
        }

        return 0;
    }
}