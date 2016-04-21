package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode110 {

    boolean isBalanced = true;

    /**
     * https://leetcode.com/problems/balanced-binary-tree/
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        depth(root, 0);
        return isBalanced;
    }

    private int depth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int left = depth(root.left, level);
        int right = depth(root.right, level);
        if (Math.abs(left - right) > 1) isBalanced = false;
        return Math.max(left, right) + 1;
    }
}
