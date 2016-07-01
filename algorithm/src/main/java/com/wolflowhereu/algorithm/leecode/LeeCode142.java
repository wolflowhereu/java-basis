package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode142 {
    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            if (head.val == -head.hashCode()) return head;
            head.val = -head.hashCode();
            head = head.next;
        }
        return null;
    }
}
