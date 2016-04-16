package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode2 {
    /**
     * https://leetcode.com/problems/add-two-numbers/
     * problem 2
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = l1;
        int tmp = 0;
        while (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + tmp;
            tmp = l1.val / 10;
            l1.val %= 10;
            if (l1.next == null) {
                l1.next = l2.next;
                break;
            }
            if (l2.next == null) break;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (tmp > 0) {
            if (l1.next == null) {
                ListNode listNode = new ListNode(tmp);
                l1.next = listNode;
                break;
            }
            l1 = l1.next;
            l1.val = l1.val + tmp;
            tmp = l1.val / 10;
            l1.val %= 10;
        }


        return result;
    }
}
