package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode143 {


    /**
     * https://leetcode.com/problems/reorder-list/
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode tail = head, half = head;

        //spit
        while (tail != null && tail.next != null) {
            tail = tail.next.next;
            half = half.next;
        }

        //reverse
        tail = half.next;
        while (tail != null && tail.next != null) {
            ListNode tmp = tail.next;
            tail.next = tmp.next;
            tmp.next = half.next;
            half.next = tmp;
        }

        //merge
        while (half != null && half.next != null) {
            ListNode tmp = half.next;
            half.next = tmp.next;
            tmp.next = head.next;
            head.next = tmp;

            head = head.next.next;
        }


    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reorderList(node);
    }


}
