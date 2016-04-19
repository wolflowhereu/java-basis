package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode98 {
    /**
     * https://leetcode.com/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        return ((root.left == null || (root.left.val < root.val && root.left.val > min && isValidBST(root.left, min, root.val)))) &&
                (root.right == null || (root.right.val > root.val && root.right.val < max && isValidBST(root.right, root.val, max)));
    }
}
