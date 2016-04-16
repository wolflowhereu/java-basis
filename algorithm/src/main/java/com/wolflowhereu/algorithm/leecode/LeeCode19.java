package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode19 {
    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head, node2 = head;
        while (n-- > 0) {
            if (node1 != null) node1 = node1.next;
        }
        if (node1 != null) {
            node1 = node1.next;
            while (node1 != null) {
                node2 = node2.next;
                node1 = node1.next;
            }
            node2.next = node2.next.next;
        } else {
            head = head.next;
        }

        return head;
    }

}
