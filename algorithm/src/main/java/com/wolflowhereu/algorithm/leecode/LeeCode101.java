package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode101 {
    /**
     * https://leetcode.com/problems/symmetric-tree/
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
