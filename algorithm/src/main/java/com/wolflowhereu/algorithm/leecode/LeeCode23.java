package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode23 {
    /**
     * https://leetcode.com/problems/merge-k-sorted-lists/
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) return null;

        int length = lists.length;
        while (length > 1) {
            int k = (length + 1) / 2;
            for (int i = 0; i < length / 2; i++)
                lists[i] = new LeeCode21().mergeTwoLists(lists[i], lists[i + k]);
            length = k;
        }

        return lists[0];
    }
}
