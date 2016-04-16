package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode25 {
    /**
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;

        ListNode tail = head;
        int n = 0;

        while (tail != null && n < k) {
            tail = tail.next;
            n++;
        }
        if (n < k) return head;
        tail = head;

        while (--n > 0) {
            ListNode tmp = tail.next;
            tail.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }

        tail.next = reverseKGroup(tail.next, k);

        return head;
    }

}
