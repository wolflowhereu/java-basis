package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode86 {

    /**
     * https://leetcode.com/problems/partition-list/
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = null, node2 = null, node11 = null, node21 = null;

        while (head != null) {
            if (head.val < x) {
                if (node1 == null) {
                    node1 = head;
                    node11 = head;
                } else {
                    node1.next = head;
                    node1 = head;
                }
            } else {
                if (node2 == null) {
                    node2 = head;
                    node21 = head;
                } else {
                    node2.next = head;
                    node2 = head;
                }
            }
            head = head.next;
        }
        if (node2 != null) node2.next = null;
        if (node1 != null) node1.next = node21;
        else node11 = node21;
        return node11;
    }


    @Test
    public void test() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        System.out.println(partition(node, 2));

    }
}
