package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-6-30.
 */
public class LeeCode148 {
    /**
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1, l2, l3, t1 = new ListNode(0), t2 = new ListNode(0), node;
        l1 = t1;
        l2 = t2;
        l3 = head;
        node = head.next;

        while (node != null) {
            if (node.val < head.val){
                l1.next = node;
                l1 = node;
            } else if (node.val > head.val) {
                l2.next = node;
                l2 = node;
            }else {
                l3.next = node;
                l3 = node;
            }
            node = node.next;
        }
        l1.next = l2.next = l3.next = node;
        t1.next = sortList(t1.next);
        l3.next = t2.next = sortList(t2.next);

        l1 = t1;
        while (l1.next != null) {
            l1 = l1.next;
        }
        l1.next = head;

        return t1.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(21);
        node.next.next = new ListNode(13);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(15);
        node = sortList(node);
        sortList(node);
    }
}
