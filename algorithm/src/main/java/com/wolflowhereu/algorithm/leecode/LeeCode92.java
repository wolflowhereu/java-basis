package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-4-16.
 */
public class LeeCode92 {

    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode l1 = new ListNode(0), l2, tmp;
        l1.next = head;
        head = l1;
        while (--m > 0) {
            l1 = l1.next;
            n--;
        }

        l2 = l1.next;

        while (--n > m) {
            tmp = l1.next;
            l1.next = l2.next;
            l2.next = l2.next.next;
            l1.next.next = tmp;
        }

        return head.next;
    }
}
