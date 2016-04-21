package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode109 {

    ListNode cHead = null;

    /**
     * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode listNode = head;
        cHead = head;
        while (listNode != null) {
            listNode = listNode.next;
            len++;
        }
        return sortedListToBST(0, len - 1);
    }


    public TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(cHead.val);
        cHead = cHead.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
