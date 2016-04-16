package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode83 {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        if (head == null) return head;
        while (head.next != null) {
            if (head.val == head.next.val) head.next = head.next.next;
            else head = head.next;
        }
        return result;
    }
}
