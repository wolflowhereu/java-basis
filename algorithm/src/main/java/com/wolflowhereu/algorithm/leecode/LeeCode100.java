package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode100 {

    /**
     * https://leetcode.com/problems/same-tree/
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
