package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode24 {
    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode listNode1 = head, listNode2 = head.next;
        if (listNode2 == null) return head;
        head = listNode2;
        while (listNode1 != null && listNode2 != null) {
            listNode1.next = listNode2.next;
            listNode2.next = listNode1;

            listNode1 = listNode1.next;
            if (listNode1 != null && listNode1.next != null) {
                listNode2.next.next = listNode1.next;
                listNode2 = listNode1.next;
            } else {
                break;
            }
        }

        return head;
    }
}
