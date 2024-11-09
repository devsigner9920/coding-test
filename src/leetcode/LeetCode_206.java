package me.dvsgn.leetcode;

public class LeetCode_206 {
    public static void main(String[] args) {
        Solution_Leet_206 sol = new Solution_Leet_206();
        System.out.println(sol.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution_Leet_206 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode node, ListNode newNode) {
        if (node.next == null) {
            return new ListNode(node.val);
        }
        return null;
//        var reversedNode = reverse(node.next);
//        reversedNode.next = new ListNode(node.val);
//        return reversedNode;
    }
}