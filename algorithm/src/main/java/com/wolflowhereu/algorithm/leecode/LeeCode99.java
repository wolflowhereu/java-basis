package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode99 {

    private TreeNode pre, first = null, second = null;


    /**
     * https://leetcode.com/problems/recover-binary-search-tree/
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        recoverTreeLDR(root);
        if (first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void recoverTreeLDR(TreeNode root) {
        if (root == null) return;
        recoverTreeLDR(root.left);

        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                second = root;
            } else {
                second = root;
            }
        }
        pre = root;
        recoverTreeLDR(root.right);
    }

    public void test() {
        char[] chars = new char[]{1, 2, 3, '#', '#', 4, '#', '#', 5};

    }
}
