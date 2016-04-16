package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode61 {

    /**
     * https://leetcode.com/problems/rotate-list/
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        ListNode newHead = head, tail = head;
        int count = 0;

        while (k-- > 0) {
            if (head==null) {
                k %= count;
                head = newHead;
            }
            head = head.next;
            count++;
        }

        if (head != null) {
            while (head.next != null) {
                newHead = newHead.next;
                head = head.next;
            }
            head.next = tail;
            head = newHead;
            newHead = newHead.next;
            head.next = null;
        }

        return newHead;
    }
}
