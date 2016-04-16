package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode82 {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) head = head.next;
            return deleteDuplicates(head.next);
        } else head.next = deleteDuplicates(head.next);
        return head;
    }
}
