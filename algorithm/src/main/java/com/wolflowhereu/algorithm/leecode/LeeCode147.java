package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-6-30.
 */
public class LeeCode147 {
    /**
     * https://leetcode.com/problems/insertion-sort-list/
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(Integer.MIN_VALUE), index = pre;
        pre.next = head;
        head = pre;

        while (head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            if (index.val > head.next.val) index = pre;
            while (index.next.val < head.next.val) {
                index = index.next;
            }

            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = index.next;
            index.next = tmp;
        }

        return pre.next;
    }
}
