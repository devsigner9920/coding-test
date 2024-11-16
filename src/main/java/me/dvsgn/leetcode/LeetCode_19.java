package me.dvsgn.leetcode;

public class LeetCode_19 {
    public static void main(String[] args) {
        Solution_l_19 sol = new Solution_l_19();
        System.out.println(sol.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }
}

class Solution_l_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var result = new ListNode(-1, head);
        // 주소 복사
        var temp = result;

        while (temp.next != null) {
            // 현재 제거 대상
            var removeTarget = temp.next;
            // 제거 대상이 맞다면?
            if (isRemove(removeTarget, n)) {
                // temp 에서 next를 제거 대상의 next로 바꿔치기 해준다.
                temp.next = removeTarget.next;
                break;
            } else {
                 temp = temp.next;
            }
        }

        return result.next;
    }

    private boolean isRemove(ListNode removeTarget, int n) {
        var temp = removeTarget;
        while (--n >= 0) {
            if (n == 0 && temp.next == null) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
