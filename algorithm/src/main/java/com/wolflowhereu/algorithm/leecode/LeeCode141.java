package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode141 {

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && head != null) {
            if (fast == head) return true;
            fast = fast.next.next;
            head = head.next;
        }
        return false;
    }
}
