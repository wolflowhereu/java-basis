package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode104 {

    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
