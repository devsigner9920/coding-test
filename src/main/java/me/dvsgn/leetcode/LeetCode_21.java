package me.dvsgn.leetcode;

public class LeetCode_21 {
    public static void main(String[] args) {
        Solution_Leet_21 sol = new Solution_Leet_21();
        sol.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_Leet_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 포인팅을 위한 더미 객체 생성
        var dummy = new ListNode();
        // 여기서 더미 객체를 포인팅하고 있기 때문에 더미 객체에 대해 계속해서 데이터가 쌓이는 중
        var cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
